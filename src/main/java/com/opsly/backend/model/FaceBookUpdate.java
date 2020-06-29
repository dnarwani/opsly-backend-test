package com.opsly.backend.model;

public class FaceBookUpdate extends SocialMediaUpdate{
    String status;

    public FaceBookUpdate(String username,String status) {
        this.username=username;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
