package com.intuit.netcalc.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "liability_group")
public class LiabilityGroupDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5251425148018501464L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "liability_group_id")
	private int grpId;

	@Column(name = "liability_group_name")
	private String groupName;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "liability_group_id", referencedColumnName = "liability_group_id")
	private Set<LiabilityDTO> liabilityList;

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}

	/**
	 * @return the grpId
	 */
	public int getGrpId() {
		return grpId;
	}

	/**
	 * @param grpId
	 *            the grpId to set
	 */
	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the liabilityList
	 */
	public Set<LiabilityDTO> getLiabilityList() {
		return liabilityList;
	}

	/**
	 * @param liabilityList
	 *            the liabilityList to set
	 */
	public void setLiabilityList(Set<LiabilityDTO> liabilityList) {
		this.liabilityList = liabilityList;
	}

}
