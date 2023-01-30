package com.letcode.practice.swordfingeroffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 面试题61. 扑克牌中的顺子
 *
 * @author lyn
 * @since 2023/1/29 22:31
 */
public class Offer_61 {


    public static boolean isStraight1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 1;
        int min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) return false;
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min < 4;
    }
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0 ;i < nums.length - 1; i ++) {
            if (nums[i] == 0) {
                joker ++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }

        int num = nums[joker];
        int num1 = nums[4];
        return num - num1 < 5;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[] {4,7,5,9,2}));
    }
}
