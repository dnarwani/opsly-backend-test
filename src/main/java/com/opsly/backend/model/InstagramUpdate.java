package com.opsly.backend.model;

public class InstagramUpdate extends SocialMediaUpdate{
    String picture;

    public InstagramUpdate(String username,String picture) {
        this.username=username;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
