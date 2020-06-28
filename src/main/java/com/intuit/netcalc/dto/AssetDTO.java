package com.intuit.netcalc.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asset_detail")
public class AssetDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6846401098030022866L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "asset_name")
	private String assetName;

	@Column(name = "asset_value")
	private double assetValue;

	@Column(name = "asset_group_id")
	private int assetGrpId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the assetName
	 */
	public String getAssetName() {
		return assetName;
	}

	/**
	 * @param assetName
	 *            the assetName to set
	 */
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	/**
	 * @return the assetValue
	 */
	public double getAssetValue() {
		return assetValue;
	}

	/**
	 * @param assetValue
	 *            the assetValue to set
	 */
	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}

	/**
	 * @return the assetGrpId
	 */
	public int getAssetGrpId() {
		return assetGrpId;
	}

	/**
	 * @param assetGrpId
	 *            the assetGrpId to set
	 */
	public void setAssetGrpId(int assetGrpId) {
		this.assetGrpId = assetGrpId;
	}
}
