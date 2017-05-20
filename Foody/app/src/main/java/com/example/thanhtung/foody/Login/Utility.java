package com.example.thanhtung.foody.Login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaios on 5/17/2017.
 */

public class Utility {
    private static Pattern pattern;
    private static Matcher matcher;
    //Email Pattern
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    /**
     * Validate Email with regular expression
     *
     * @param email
     * @return true for Valid Email and false for Invalid Email
     */
    public static boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();

    }
    public static boolean validatePaswordLength(String password) {
        return password.length() >= 4 ;

    }
    public static boolean validatePasword(String password1, String password2) {
        return password1.matches(password2);

    }
    public static boolean validateString(String s1, String s2) {
        return s1.matches(s2);

    }
    /**
     * Checks for Null String object
     *
     * @param txt
     * @return true for not null and false for null String object
     */
    public static boolean isNotNull(String txt){
        return txt!=null && txt.trim().length()>0 ? true: false;
    }
}