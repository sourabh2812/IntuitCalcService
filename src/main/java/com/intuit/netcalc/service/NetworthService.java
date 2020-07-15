package com.intuit.netcalc.service;

import java.util.concurrent.Future;

import com.intuit.netcalc.bean.NetworthRequest;
import com.intuit.netcalc.bean.NetworthResponse;

public interface NetworthService {

	public Future<NetworthResponse> getAllFinances();

	public void updateRecord(NetworthRequest request);

	public void deleteRecord(NetworthRequest request);
}
