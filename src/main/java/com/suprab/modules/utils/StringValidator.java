package com.suprab.modules.utils;

import org.springframework.util.StringUtils;

public class StringValidator {

    private StringValidator(){

    }

    public static boolean isEmptyOrNull(String s) {
        return s == null || StringUtils.isEmpty(s);
    }
}
