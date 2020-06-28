package com.intuit.netcalc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intuit.netcalc.dto.CurrencyDTO;

public interface CurrencyDAO extends JpaRepository<CurrencyDTO, Long> {

}
