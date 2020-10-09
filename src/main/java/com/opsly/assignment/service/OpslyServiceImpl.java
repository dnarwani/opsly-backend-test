package com.opsly.assignment.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.opsly.assignment.model.InfoResponse;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@Service
public class OpslyServiceImpl implements OpslyService {
	
	private final WebClient client;

	@Override
	public Mono<InfoResponse> getCustomerSocialInfo() {
		// TODO Auto-generated method stub
		/*InfoResponse response = new InfoResponse();
		client.get().uri("/twitter").retrieve().bodyToMono(String.class)
		.onErrorReturn("We could not retrive data").subscribe(response::setTwitter);
		client.get().uri("/facebook").retrieve().bodyToMono(String.class)
		.onErrorReturn("We could not retrive data").subscribe(response::setFacebook);
		client.get().uri("/instagram").retrieve().bodyToMono(String.class)
		.onErrorReturn("We could not retrive data").subscribe(response::setInstagram);
        */
		
		Mono<String> twitter = client.get().uri("/twitter").retrieve().bodyToMono(String.class).onErrorReturn("We could not retrive data").subscribeOn(Schedulers.elastic());
		Mono<String> facebook = client.get().uri("/facebook").retrieve().bodyToMono(String.class).onErrorReturn("We could not retrive data").subscribeOn(Schedulers.elastic());
		Mono<String> instagram = client.get().uri("/instagram").retrieve().bodyToMono(String.class).onErrorReturn("We could not retrive data").subscribeOn(Schedulers.elastic());
		
		twitter.subscribe(System.out::println);
		facebook.subscribe(System.out::println);
		instagram.subscribe(System.out::println);
		
		return Mono.zip(twitter, facebook,instagram).flatMap(transformer-> {
			return Mono.just(new InfoResponse(transformer.getT1(),transformer.getT2(),transformer.getT3()));
		});
	
		
	}

}
