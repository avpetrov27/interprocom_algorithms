package ru.interprocom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {
    private final static Pattern PATTERN_IPV4 = Pattern.compile("1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d");
    private final static Pattern PATTERN_IPV6 = Pattern.compile("[0-9a-fA-F]{1,4}");

    public String validIPAddress(String queryIP) {
        String ret = "Neither";
        if (isMatch(PATTERN_IPV4, "\\.", queryIP, 4)) {
            ret = "IPv4";
        }
        if (isMatch(PATTERN_IPV6, ":", queryIP, 8)) {
            ret = "IPv6";
        }
        return ret;
    }

    private boolean isMatch(Pattern pattern, String delimiter, String queryIP, int count) {
        String[] arr = queryIP.split(delimiter, count);
        boolean flag = true;
        if (arr.length != count) {
            flag = false;
        } else {
            for (String s : arr) {
                Matcher matcher = pattern.matcher(s);
                if (!matcher.matches()) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        ValidateIPAddress valid = new ValidateIPAddress();
        System.out.println(valid.validIPAddress("219.219.219.219"));
    }
}
