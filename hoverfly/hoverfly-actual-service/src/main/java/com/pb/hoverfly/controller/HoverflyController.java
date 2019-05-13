package com.pb.hoverfly.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pb.hoverfly.domain.HoverflyServiceResponse;

@RestController
public class HoverflyController {

	@RequestMapping(value = "/service/hoverfly")
	public HoverflyServiceResponse getSampleResponse() {
		System.out.println("Inside HoverflyActualServiceApplication::getSampleResponse()");
		
		return new HoverflyServiceResponse("returned value from HoverflyActualServiceApplication",
				new Date().toString(), UUID.randomUUID().toString());
	}
}
