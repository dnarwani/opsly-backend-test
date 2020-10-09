package com.opsly.assignment.service;

import com.opsly.assignment.model.InfoResponse;

import reactor.core.publisher.Mono;

public interface OpslyService {
	
	Mono<InfoResponse> getCustomerSocialInfo();

}
