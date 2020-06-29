package com.opsly.backend.utils;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class WebClient {


    public static ResponseEntity<?> callMethod(String url, MediaType mediaType, HttpMethod httpMethod) throws APICallException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        HttpEntity<String> httpEntity = getHttpEntity(mediaType);
        return restTemplate.exchange(url, httpMethod, httpEntity, Object.class);
    }
    
    public static HttpEntity<String> getHttpEntity(MediaType mediaType) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(mediaType));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return new HttpEntity<String>("parameters", headers);

    }

}
