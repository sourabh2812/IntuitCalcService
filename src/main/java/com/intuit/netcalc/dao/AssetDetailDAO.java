package com.intuit.netcalc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.netcalc.dto.AssetDTO;

@Repository
public interface AssetDetailDAO extends JpaRepository<AssetDTO, Long> {

}
