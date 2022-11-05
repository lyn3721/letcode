package com.letcode.practice;

import java.util.Arrays;

/**
 * 1413. 逐步求和得到正数的最小值
 *
 * @author lyn
 * @since 2022/8/9 23:14
 */
public class MINIMUM_VALUE_TO_GET_POSITIVE_STEP_BY_STEP_SUM {
    /**
     * 给你一个整数数组 nums。你可以选定任意的正数 startValue 作为初始值。
     *
     * 你需要从左到右遍历 nums数组，并将 startValue 依次累加上nums数组中的值。
     *
     * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的正数作为 startValue 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int minStartValue(int[] nums) {
//        int[] arr = new int[nums.length];
//        int sum = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            arr[i] = sum + nums[i];
//            sum += nums[i];
//        }
//        int[] ints = Arrays.stream(arr).sorted().toArray();
//        int i = ints[0];
//        if (i > 0) {
//            return 1;
//        }
//        return Math.abs(i) + 1;
        int accSum = 0, accSumMin = 0;
        for (int num : nums) {
            accSum += num;
            accSumMin = Math.min(accSumMin, accSum);
        }
        return -accSumMin + 1;
    }

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{1,2}));
    }
}
