package com.intuit.netcalc.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.netcalc.bean.NetworthRequest;
import com.intuit.netcalc.bean.NetworthResponse;
import com.intuit.netcalc.service.NetworthService;

@CrossOrigin()
@RestController
public class NetworthController {

	@Autowired
	NetworthService networthService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Callable<NetworthResponse> getAllFinances() {
		return () -> {
			Future<NetworthResponse> networthResponse = networthService.getAllFinances();
			return networthResponse.get(10000, TimeUnit.MILLISECONDS);
		};
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public HttpStatus updateRecord(@RequestBody NetworthRequest request) {
		networthService.updateRecord(request);
		return HttpStatus.OK;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public HttpStatus deleteRecord(@RequestBody NetworthRequest request) {
		networthService.deleteRecord(request);
		return HttpStatus.OK;
	}

}
