package com.intuit.netcalc.bean;

import java.io.Serializable;
import java.util.List;

import com.intuit.netcalc.dto.AssetDTO;
import com.intuit.netcalc.dto.CurrencyDTO;
import com.intuit.netcalc.dto.LiabilityDTO;

public class NetworthRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3831712171270836022L;

	private List<AssetDTO> assetList;

	private List<LiabilityDTO> liabilityList;

	private List<CurrencyDTO> currencyList;

	private double netWorth;

	private String selectedCurrency;

	/**
	 * @return the assetList
	 */
	public List<AssetDTO> getAssetList() {
		return assetList;
	}

	/**
	 * @param assetList
	 *            the assetList to set
	 */
	public void setAssetList(List<AssetDTO> assetList) {
		this.assetList = assetList;
	}

	/**
	 * @return the liabilityList
	 */
	public List<LiabilityDTO> getLiabilityList() {
		return liabilityList;
	}

	/**
	 * @param liabilityList
	 *            the liabilityList to set
	 */
	public void setLiabilityList(List<LiabilityDTO> liabilityList) {
		this.liabilityList = liabilityList;
	}

	/**
	 * @return the currencyList
	 */
	public List<CurrencyDTO> getCurrencyList() {
		return currencyList;
	}

	/**
	 * @param currencyList
	 *            the currencyList to set
	 */
	public void setCurrencyList(List<CurrencyDTO> currencyList) {
		this.currencyList = currencyList;
	}

	/**
	 * @return the netWorth
	 */
	public double getNetWorth() {
		return netWorth;
	}

	/**
	 * @param netWorth
	 *            the netWorth to set
	 */
	public void setNetWorth(double netWorth) {
		this.netWorth = netWorth;
	}

	/**
	 * @return the selectedCurrency
	 */
	public String getSelectedCurrency() {
		return selectedCurrency;
	}

	/**
	 * @param selectedCurrency
	 *            the selectedCurrency to set
	 */
	public void setSelectedCurrency(String selectedCurrency) {
		this.selectedCurrency = selectedCurrency;
	}

}
