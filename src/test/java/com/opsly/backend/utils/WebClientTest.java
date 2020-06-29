package com.opsly.backend.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WebClientTest {


    @Test
    void getHttpEntity() {
        HttpEntity<String> httpEntity = WebClient.getHttpEntity(MediaType.APPLICATION_JSON);
        assert (httpEntity != null);
        assert (httpEntity.getHeaders().size() > 0);
    }

    @Test
    void callMethodInvalidURI() {

        assertThrows(IllegalArgumentException.class, () -> {
                    ResponseEntity<?> responseEntity = WebClient.callMethod("", MediaType.APPLICATION_JSON, HttpMethod.GET);
                }
        );
    }


    @Test
    void callMethod_Success() {

        String apiURL = "https://httpbin.org/get";
        try {
            ResponseEntity<?> responseEntity = WebClient.callMethod(apiURL, MediaType.APPLICATION_JSON, HttpMethod.GET);
            assert (responseEntity != null);
            assert (responseEntity.getStatusCode() == HttpStatus.OK);
            assert (responseEntity.getBody() != null);
        } catch (APICallException e) {

        }

    }





}