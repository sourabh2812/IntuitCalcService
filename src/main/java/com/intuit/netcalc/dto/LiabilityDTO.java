package com.intuit.netcalc.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "liability_detail")
public class LiabilityDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3113582031474705758L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "liability_name")
	private String liabilityName;

	@Column(name = "liability_value")
	private double liabilityValue;

	@Column(name = "liability_group_id")
	private int liabilityGrpId;

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
	 * @return the liabilityName
	 */
	public String getLiabilityName() {
		return liabilityName;
	}

	/**
	 * @param liabilityName
	 *            the liabilityName to set
	 */
	public void setLiabilityName(String liabilityName) {
		this.liabilityName = liabilityName;
	}

	/**
	 * @return the liabilityValue
	 */
	public double getLiabilityValue() {
		return liabilityValue;
	}

	/**
	 * @param liabilityValue
	 *            the liabilityValue to set
	 */
	public void setLiabilityValue(double liabilityValue) {
		this.liabilityValue = liabilityValue;
	}

	/**
	 * @return the liabilityGrpId
	 */
	public int getLiabilityGrpId() {
		return liabilityGrpId;
	}

	/**
	 * @param liabilityGrpId
	 *            the liabilityGrpId to set
	 */
	public void setLiabilityGrpId(int liabilityGrpId) {
		this.liabilityGrpId = liabilityGrpId;
	}

}
