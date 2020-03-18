package com.example.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Test {

    /**
     * 26大小写字母+数字
     */
    private static final String REGEX = "^[A-Za-z0-9]+$";

    public static void main(String[] args) {
        String str = "11111zhongZ.";
        Pattern pattern = Pattern.compile(REGEX);
        if (!pattern.matcher(str).matches()){
            System.out.println("正则效验未通过!");
        }
    }

}
