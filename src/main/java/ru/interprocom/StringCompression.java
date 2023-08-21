package ru.interprocom;

public class StringCompression {
    public static int compress(char[] chars) {
        int count = 1;
        int index = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            }
            if (chars[i] != chars[i + 1]) {
                chars[index++] = chars[i];
                if (count > 1) {
                    char[] digits = Integer.toString(count).toCharArray();
                    for (char digit : digits) {
                        chars[index++] = digit;
                    }
                }
                count = 1;
            }
        }
        chars[index++] = chars[chars.length - 1];
        if (count > 1) {
            char[] digits = Integer.toString(count).toCharArray();
            for (char digit : digits) {
                chars[index++] = digit;
            }
        }
        for (int i = index; i < chars.length; i++) {
            chars[i] = ' ';
        }
        return index;
    }

    public static void main(String[] args) {
        char[] input = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c', 'd'};
        System.out.println(compress(input));
    }
}
