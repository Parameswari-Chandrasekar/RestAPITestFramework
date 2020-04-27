package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

    public static String empName(){
        String genString = RandomStringUtils.randomAlphabetic(2);
        return ("Shiva"+genString);
    }

    public static String empSal(){
        String genString = RandomStringUtils.randomNumeric(5);
        return (genString);
    }

    public static String empAge(){
        String genString = RandomStringUtils.randomNumeric(2);
        return (genString);
    }
}
