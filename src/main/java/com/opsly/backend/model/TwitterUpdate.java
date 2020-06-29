package com.opsly.backend.model;

public class TwitterUpdate extends SocialMediaUpdate{
    String tweet;

    public TwitterUpdate(String username,String tweet) {
        this.username=username;
        this.tweet = tweet;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
