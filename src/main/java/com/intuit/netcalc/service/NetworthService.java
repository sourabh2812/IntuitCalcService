package com.intuit.netcalc.service;

import java.util.concurrent.Future;

import com.intuit.netcalc.bean.NetworthResponse;

public interface NetworthService {

	public Future<NetworthResponse> getAllFinances();
}
