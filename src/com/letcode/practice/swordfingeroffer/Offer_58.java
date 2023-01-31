package com.letcode.practice.swordfingeroffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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



    public static  int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++ ) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }

        if (nums.length == 1 ) {
            if (nums[0] == 0) {

                return 1;
            } else {
                return nums[0] - 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
    private Deque<Integer> de = new ArrayDeque<>();


    public static void main(String[] args) {
//        System.out.println(missingNumber(new int[]{0, 1}));

        System.out.println(reverseWords("  hello world!  "));
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = arr.length - 1; i >= 0; i --) {
            list.add(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(String a : list) {
            if (!a.isEmpty()) {
                sb.append(a.replace(" ", "") + " ");
            }
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }



}
