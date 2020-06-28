package com.intuit.netcalc.service.impl;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.intuit.netcalc.bean.NetworthResponse;
import com.intuit.netcalc.dao.AssetGroupDAO;
import com.intuit.netcalc.dao.CurrencyDAO;
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
	private LiabilityGroupDAO liabilityGroupDao;

	@Autowired
	private CurrencyDAO currencyDao;

	@Override
	@Async
	public Future<NetworthResponse> getAllFinances() {
		NetworthResponse response = new NetworthResponse();

		List<AssetGroupDTO> assetGroupList = assetGroupDao.findAll();
		List<LiabilityGroupDTO> liabilityGroupList = liabilityGroupDao.findAll();
		List<CurrencyDTO> currencyList = currencyDao.findAll();

		response.setAssetGroupList(assetGroupList);
		response.setLiabilityGroupList(liabilityGroupList);
		response.setCurrencyList(currencyList);

		// Calculate and set net value of finances
		this.netWorth(response);

		return new AsyncResult<NetworthResponse>(response);
	}

	private void netWorth(NetworthResponse response) {
		Double netAsset = response.getAssetGroupList().parallelStream().flatMap(a -> a.getAssetList().stream())
				.mapToDouble(AssetDTO::getAssetValue).reduce(0, Double::sum);
		response.setNetAssetValue(netAsset);

		Double netLiability = response.getLiabilityGroupList().parallelStream()
				.flatMap(l -> l.getLiabilityList().stream()).mapToDouble(LiabilityDTO::getLiabilityValue)
				.reduce(0, Double::sum);
		response.setNetLiabilityValue(netLiability);
	}

}
