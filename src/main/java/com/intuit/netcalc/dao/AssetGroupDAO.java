package com.intuit.netcalc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.netcalc.dto.AssetGroupDTO;

@Repository
public interface AssetGroupDAO extends JpaRepository<AssetGroupDTO, Long> {

}
