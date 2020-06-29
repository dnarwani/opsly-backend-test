package com.opsly.backend.services;

import com.opsly.backend.model.SocialMediaUpdate;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SocialNetworkStatusReaderTest {

    @Test
    void getSocialMediaUpdate() {

        HashMap<String,String> socialNetworks = new HashMap<>();
        socialNetworks.put("twitter","https://takehome.io/twitter");

        SocialNetworkStatusReader snsr= new SocialNetworkStatusReader(socialNetworks) ;
        String socialMediaUpdate = snsr.getSocialMediaUpdate();

        assert (socialMediaUpdate!=null);
    }
}