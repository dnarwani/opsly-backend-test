package com.opsly.backend.services;

import com.opsly.backend.utils.APICallException;
import com.opsly.backend.utils.JsonDataFormatter;
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
                    sb.append("[");
                    sb.append(getNetworkUpdates(socialMediaNetwork.getValue(), socialMediaNetwork.getKey()));
                    sb.append("]");
                    sb.append(",");
                }
        );

        sb.append("}");
        return sb.toString();
    }

    private HashMap<String, String> getKeyNames(String smn) {

        HashMap<String, String> keyValuePair = new HashMap<>();
        keyValuePair.put("firstKey", "username");
        switch (smn.toLowerCase()) {
            case "twitter":
                keyValuePair.put("secondKey", "tweet");
                return keyValuePair;
            case "facebook":
                keyValuePair.put("firstKey", "name");
                keyValuePair.put("secondKey", "status");
                return keyValuePair;
            case "instagram":
                keyValuePair.put("secondKey", "picture");
                return keyValuePair;

        }
        return keyValuePair;
    }


    private String getNetworkUpdates(String uri, String smn) {
        try {
            ResponseEntity<?> responseEntity = WebClient.callMethod(uri, MediaType.APPLICATION_JSON, HttpMethod.GET);
            ArrayList<HashMap> body2 = (ArrayList<HashMap>) responseEntity.getBody();// cast this to ArrayList<HashMap> body

            HashMap<String, String> keyNames = getKeyNames(smn);
            String res = JsonDataFormatter.formatBody(body2, keyNames);

            return res;

        } catch (ResourceAccessException exception) {
            return '"' + "Unable to access" + uri + '"';
        } catch (APICallException e) {
            return e.getMessage();
        }
    }


}
