package com.thomas.followimprove.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final Pattern p = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@\" \n" +
            "        + \"[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$") ;
    private Utils(){}
    public static boolean checkEmailIsValid(String email){
        Matcher m = p.matcher(email) ;
        return m.matches();
    }


}
