package com.letcode.learn.sort;

/**
 * @author lyn
 * @since 2022/11/12 17:32
 */
public class RadixSort {


    public int maxDigit(int[] arr) {

        Integer max = Integer.MAX_VALUE;
        for (int i : arr) {

            max = Math.max(max, i);
        }
        int res = 0;

        while (max != 0) {
            res ++;
            max = max / 10;
        }

        return res;

    }

    public static void radixSort(int[] arr, int l, int r, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        //多少个数 就准备多少个辅助空间
        int[] bucket = new int[r - l + 1];
        //有多少位就进出几次
        for (int k = 0; k < digit; k++) {
            // 10个空间
            // count[0] 当前位 是k位数字有多少个
            // count[1] 当前位 是k位数字 (0和1) 数字有多少个
            // count[2] 当前位 是k位数字 (0,1,2) 数字有多少个
            // count[i] 当前位 是k位数字 (0~i) 数字有多少个
            int[] count = new int [radix];
            for (i = l ; i <= r ; i ++ ) {
                j = getDigit(arr[l], digit);
                //获取j位置的数字并 记录该位置出现几次
                count[j] ++;
            }

            for (i = 1; i < radix; i++) {
                //从词频数组变成前缀和数组
                count[i] = count[i] + count[i - 1];
            }

            for (i = r; i >= l ; i--) {
                j = getDigit(arr[i], digit);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = bucket[j];

            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
