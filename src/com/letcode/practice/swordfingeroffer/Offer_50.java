package com.letcode.practice.swordfingeroffer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * @author lyn
 * @since 2023/1/18 18:34
 */
public class Offer_50 {
    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> li = new LinkedHashMap<>();
        for (char aChar : chars) {
            li.put(aChar, li.getOrDefault(aChar, 0) + 1);
        }
        char a = ' ';
        for (Map.Entry<Character, Integer> entry : li.entrySet()) {
            Integer v = entry.getValue();
            if (v == 1) {

                return entry.getKey();
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
