package com.opsly.backend.services;

import java.util.HashMap;

public class SocialNetworkStatusReader {

    private HashMap<String,String> socialNetworks= new HashMap<>();

    public SocialNetworkStatusReader(HashMap<String, String> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public HashMap<String, String> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(HashMap<String, String> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }
}
