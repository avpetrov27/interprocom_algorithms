package ru.interprocom;

import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.toLowerCase;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        boolean ret = true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (!isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j))) {
                ret = false;
                break;
            }
            i++;
            j--;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }
}
