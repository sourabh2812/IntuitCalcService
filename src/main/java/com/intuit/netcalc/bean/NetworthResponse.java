package com.intuit.netcalc.bean;

import java.io.Serializable;
import java.util.List;

import com.intuit.netcalc.dto.AssetGroupDTO;
import com.intuit.netcalc.dto.CurrencyDTO;
import com.intuit.netcalc.dto.LiabilityGroupDTO;

public class NetworthResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 48150369124718521L;

	private List<AssetGroupDTO> assetGroupList;

	private List<LiabilityGroupDTO> liabilityGroupList;

	private List<CurrencyDTO> currencyList;

	private double netAssetValue;

	private double netLiabilityValue;

	/**
	 * @return the assetGroupList
	 */
	public List<AssetGroupDTO> getAssetGroupList() {
		return assetGroupList;
	}

	/**
	 * @param assetGroupList
	 *            the assetGroupList to set
	 */
	public void setAssetGroupList(List<AssetGroupDTO> assetGroupList) {
		this.assetGroupList = assetGroupList;
	}

	/**
	 * @return the liabilityGroupList
	 */
	public List<LiabilityGroupDTO> getLiabilityGroupList() {
		return liabilityGroupList;
	}

	/**
	 * @param liabilityGroupList
	 *            the liabilityGroupList to set
	 */
	public void setLiabilityGroupList(List<LiabilityGroupDTO> liabilityGroupList) {
		this.liabilityGroupList = liabilityGroupList;
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
	 * @return the netAssetValue
	 */
	public double getNetAssetValue() {
		return netAssetValue;
	}

	/**
	 * @param netAssetValue
	 *            the netAssetValue to set
	 */
	public void setNetAssetValue(double netAssetValue) {
		this.netAssetValue = netAssetValue;
	}

	/**
	 * @return the netLiabilityValue
	 */
	public double getNetLiabilityValue() {
		return netLiabilityValue;
	}

	/**
	 * @param netLiabilityValue
	 *            the netLiabilityValue to set
	 */
	public void setNetLiabilityValue(double netLiabilityValue) {
		this.netLiabilityValue = netLiabilityValue;
	}

}
