package com.letcode.practice.general.str;

/**
 * @author lyn
 * @since 2022/8/1 19:39
 */
public class Generate_a_string_with_characters_that_have_odd_counts {

    public static String generateTheString(int n) {
        StringBuilder str = new StringBuilder();


        if (n % 2 == 1) {
            for (int i = 0; i < n - 1; i++) {
                str.append("b");
            }
            return str.toString();
        }
        for (int i = 0; i < n - 2; i++) {
            str.append("b");
        }
        str.append("a");
        return str.toString();

    }

    public static void main(String[] args) {
        System.out.println(generateTheString(1));
        System.out.println(generateTheString(2));
        System.out.println(generateTheString(3));
        System.out.println(generateTheString(5));
        System.out.println(generateTheString(8));
    }
}
