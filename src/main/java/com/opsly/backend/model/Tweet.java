package com.opsly.backend.model;

public class Tweet extends SocialMediaUpdate {
    String tweet;

    public Tweet(String username, String tweet) {
        this.username = username;
        this.tweet = tweet;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
