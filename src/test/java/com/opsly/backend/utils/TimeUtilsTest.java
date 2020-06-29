package com.opsly.backend.utils;

import org.junit.jupiter.api.Test;

class TimeUtilsTest {

    @Test
    void getCurrentTime() {

        String currentTime = TimeUtils.getCurrentTime();
        assert (currentTime != null);
    }
}