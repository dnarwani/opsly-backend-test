package com.opsly.backend.controllers;


import com.opsly.backend.services.SocialNetworkStatusReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HomeController {


    @RequestMapping("/")
    public String index() {

        HashMap<String, String> socialNetworks = new HashMap<>();
        socialNetworks.put("twitter", "https://takehome.io/twitter");
        socialNetworks.put("facebook", "https://takehome.io/facebook");
        socialNetworks.put("instagram", "https://takehome.io/instagram");

        SocialNetworkStatusReader snsr = new SocialNetworkStatusReader(socialNetworks);
        String socialMediaUpdate = snsr.getSocialMediaUpdate();


        return socialMediaUpdate;
    }

}
