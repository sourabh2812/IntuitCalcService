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
@Table(name = "asset_group")
public class AssetGroupDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2466271967996370031L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "asset_group_id")
	private int groupId;

	@Column(name = "asset_group_name")
	private String groupName;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "asset_group_id", referencedColumnName = "asset_group_id")
	private Set<AssetDTO> assetList;

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
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
	 * @return the assetList
	 */
	public Set<AssetDTO> getAssetList() {
		return assetList;
	}

	/**
	 * @param assetList
	 *            the assetList to set
	 */
	public void setAssetList(Set<AssetDTO> assetList) {
		this.assetList = assetList;
	}

}
