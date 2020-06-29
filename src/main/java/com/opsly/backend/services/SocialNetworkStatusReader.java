package com.opsly.backend.services;

import com.opsly.backend.utils.APICallException;
import com.opsly.backend.utils.WebClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class SocialNetworkStatusReader {

    private HashMap<String, String> socialNetworks = new HashMap<>();

    public SocialNetworkStatusReader(HashMap<String, String> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public HashMap<String, String> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(HashMap<String, String> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public String getSocialMediaUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        socialNetworks.entrySet().stream().forEach(socialMediaNetwork -> {
                    sb.append('"' + socialMediaNetwork.getKey() + '"');
                    sb.append(":");
                    sb.append(getNetworkUpdates(socialMediaNetwork.getValue()));
                    sb.append(",");
                }
        );

        sb.append("}");
        return sb.toString();
    }

    private String getNetworkUpdates(String uri) {
        try {
            ResponseEntity<?> responseEntity = WebClient.callMethod(uri, MediaType.APPLICATION_JSON, HttpMethod.GET);
            return responseEntity.getBody().toString();
        } catch (APICallException e) {
            return e.getMessage();
        }
    }
}
