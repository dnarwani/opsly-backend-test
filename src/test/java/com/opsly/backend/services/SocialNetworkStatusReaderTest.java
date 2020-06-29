package com.opsly.backend.services;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class SocialNetworkStatusReaderTest {

    @Test
    void getSocialMediaUpdate() {

        HashMap<String, String> socialNetworks = new HashMap<>();
        socialNetworks.put("twitter", "https://takehome.io/twitter");
        socialNetworks.put("facebook", "https://takehome.io/facebook");
        socialNetworks.put("instagram", "https://takehome.io/instagram");

        SocialNetworkStatusReader snsr = new SocialNetworkStatusReader(socialNetworks);
        String socialMediaUpdate = snsr.getSocialMediaUpdate();

        assert (socialMediaUpdate != null);
    }

}