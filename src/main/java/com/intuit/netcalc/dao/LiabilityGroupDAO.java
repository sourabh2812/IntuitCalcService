package com.intuit.netcalc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intuit.netcalc.dto.LiabilityGroupDTO;

public interface LiabilityGroupDAO extends JpaRepository<LiabilityGroupDTO, Long> {

}