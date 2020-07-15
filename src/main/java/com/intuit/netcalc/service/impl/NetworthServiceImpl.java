package com.intuit.netcalc.service.impl;

import static com.intuit.netcalc.constants.AppConstants.ASSET;
import static com.intuit.netcalc.constants.AppConstants.LIABILITY;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.intuit.netcalc.bean.NetworthRequest;
import com.intuit.netcalc.bean.NetworthResponse;
import com.intuit.netcalc.dao.AssetDetailDAO;
import com.intuit.netcalc.dao.AssetGroupDAO;
import com.intuit.netcalc.dao.CurrencyDAO;
import com.intuit.netcalc.dao.LiabilityDetailDAO;
import com.intuit.netcalc.dao.LiabilityGroupDAO;
import com.intuit.netcalc.dto.AssetDTO;
import com.intuit.netcalc.dto.AssetGroupDTO;
import com.intuit.netcalc.dto.CurrencyDTO;
import com.intuit.netcalc.dto.LiabilityDTO;
import com.intuit.netcalc.dto.LiabilityGroupDTO;
import com.intuit.netcalc.service.NetworthService;

@Service
public class NetworthServiceImpl implements NetworthService {

	@Autowired
	private AssetGroupDAO assetGroupDao;

	@Autowired
	private AssetDetailDAO assetDetailDao;

	@Autowired
	private LiabilityGroupDAO liabilityGroupDao;

	@Autowired
	private LiabilityDetailDAO liabilityDetailDao;

	@Autowired
	private CurrencyDAO currencyDao;

	/**
	 * Service method to fetch all records
	 */
	@Override
	@Async
	public Future<NetworthResponse> getAllFinances() {
		NetworthResponse response = new NetworthResponse();

		List<AssetGroupDTO> assetGroupList = assetGroupDao.findAll();
		response.setAssetGroupList(assetGroupList);

		List<LiabilityGroupDTO> liabilityGroupList = liabilityGroupDao.findAll();
		response.setLiabilityGroupList(liabilityGroupList);

		response.setCurrencyList(currencyDao.findAll());
		// Calculate and set net value of finances
		this.netWorth(response);

		return new AsyncResult<NetworthResponse>(response);
	}

	/**
	 * Service method to update record
	 */
	@Override
	@Transactional
	public void updateRecord(NetworthRequest request) {
		Optional<AssetDTO> asset = null;
		Optional<LiabilityDTO> liability = null;

		// Updating assets
		if (request.getCategoryType().equals(ASSET)) {
			asset = assetDetailDao.findById(request.getId());
			if (asset.isPresent()) {
				// to always save value in base currency (USD)
				asset.get().setAssetValue(convertToBaseCurrency(request));

				assetDetailDao.saveAndFlush(asset.get());
			}
		}
		// updating liabilities
		else if (request.getCategoryType().equals(LIABILITY)) {
			liability = liabilityDetailDao.findById(request.getId());
			if (liability.isPresent()) {
				// to always save value in base currency (USD)
				liability.get().setLiabilityValue(convertToBaseCurrency(request));

				liabilityDetailDao.saveAndFlush(liability.get());
			}
		}
	}

	/**
	 * Service method to delete a record
	 */
	@Override
	@Transactional
	public void deleteRecord(NetworthRequest request) {
		if (request.getCategoryType().equals(ASSET)) {
			assetDetailDao.deleteById(request.getId());
		} else if (request.getCategoryType().equals(LIABILITY)) {
			liabilityDetailDao.deleteById(request.getId());
		}
	}

	/**
	 * Service method to calculate net assets and liability
	 */
	private void netWorth(NetworthResponse response) {
		Double netAsset = response.getAssetGroupList().parallelStream().flatMap(a -> a.getAssetList().stream())
				.mapToDouble(AssetDTO::getAssetValue).reduce(0, Double::sum);
		response.setNetAssetValue(netAsset);

		Double netLiability = response.getLiabilityGroupList().parallelStream()
				.flatMap(l -> l.getLiabilityList().stream()).mapToDouble(LiabilityDTO::getLiabilityValue)
				.reduce(0, Double::sum);
		response.setNetLiabilityValue(netLiability);
	}

	/**
	 * Service method to convert to USD before updating record value
	 */
	@Transactional
	private double convertToBaseCurrency(NetworthRequest request) {
		List<CurrencyDTO> currencyList = currencyDao.findAll();

		Double calculatedValue = null;

		for (CurrencyDTO currency : currencyList) {
			if (currency.getCurrencyCode().equals(request.getCurrencyCode())) {
				calculatedValue = request.getValue() / currency.getCurrencyValue();
			}
		}
		return calculatedValue;
	}

}
