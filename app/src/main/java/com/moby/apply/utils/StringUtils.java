package com.moby.apply.utils;

/**
 * Created by patel on 6/26/2017.
 */

public class StringUtils {
    public static boolean isNotNullOrEmpty(String s) {
        return s != null && s.trim().length() > 0;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().length() <= 0;
    }
}
