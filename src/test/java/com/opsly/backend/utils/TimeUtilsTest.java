package com.opsly.backend.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {

    @Test
    void getCurrentTime() {

        String currentTime = TimeUtils.getCurrentTime();
        assert (currentTime!=null);
    }
}