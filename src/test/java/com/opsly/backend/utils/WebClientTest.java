package com.opsly.backend.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class WebClientTest {





    @Test
    void getHttpEntity() {
        HttpEntity<String> httpEntity = WebClient.getHttpEntity(MediaType.APPLICATION_JSON);
        assert (httpEntity!=null);
        assert (httpEntity.getHeaders().size()>0);
    }

    @Test
    void callMethod() {

        ResponseEntity<?> responseEntity = WebClient.callMethod("", MediaType.APPLICATION_JSON, HttpMethod.GET);
        assert(responseEntity!=null);

    }
}