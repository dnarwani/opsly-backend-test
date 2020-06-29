package com.opsly.backend.services;

import com.opsly.backend.utils.APICallException;
import com.opsly.backend.utils.WebClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
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
            Object body = responseEntity.getBody();
            return responseEntity.getBody().toString().replace('\n', ' ');// todo here you should parse the body to relavent Model objects for further impl
        } catch (ResourceAccessException exception) {
            return '"' + "Unable to access" + uri + '"';
        } catch (APICallException e) {
            return e.getMessage();
        }
    }


}
