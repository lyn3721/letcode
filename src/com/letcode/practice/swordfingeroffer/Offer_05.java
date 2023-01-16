package com.letcode.practice.swordfingeroffer;

/**
 * 剑指 Offer 05. 替换空格
 *
 * @author lyn
 * @since 2023/1/16 01:04
 */
public class Offer_05 {
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {

            if (aChar == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(aChar);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

}
