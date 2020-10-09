package com.opsly.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opsly.assignment.model.InfoResponse;
import com.opsly.assignment.service.OpslyService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class OpslyController {

	private final OpslyService opslyService;
	
	@GetMapping()
	public Mono<InfoResponse> getCustomerSocialInfo() {
		return opslyService.getCustomerSocialInfo();
	}

}
