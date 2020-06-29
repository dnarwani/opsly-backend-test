package com.opsly.backend.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {

    public static SimpleDateFormat simpleDateFormat_UK = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.UK);

    public static String getCurrentTime(SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    public static String getCurrentTime() {
        return simpleDateFormat_UK.format(new Date(System.currentTimeMillis()));
    }


}
