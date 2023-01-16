package com.letcode.practice.swordfingeroffer;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * @author lyn
 * @since 2023/1/16 01:09
 */
public class Offer_58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i <= n) {
                stringBuilder1.append(chars[i]);
            } else {
                stringBuilder.append(chars[i]);

            }
        }
        return stringBuilder.toString() + stringBuilder1.toString();
    }

}
