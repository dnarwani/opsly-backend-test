package com.opsly.backend.model;

public class Photo extends SocialMediaUpdate {
    String picture; // may be url of the picture or complex object

    public Photo(String username, String picture) {
        this.username = username;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
