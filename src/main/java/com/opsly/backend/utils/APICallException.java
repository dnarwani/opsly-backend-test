package com.opsly.backend.utils;

import java.io.IOException;

public class APICallException extends IOException {

    /*
    MVP impl of api call exception
     */

    public APICallException(String errorMessage) {


        super(TimeUtils.getCurrentTime() + " -- " + errorMessage);
    }
}
