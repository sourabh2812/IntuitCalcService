package com.intuit.netcalc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intuit.netcalc.dto.LiabilityDTO;

public interface LiabilityDetailDAO extends JpaRepository<LiabilityDTO, Long> {

}