package com.letcode.learn.sort;

import java.util.Arrays;

/**
 * 归并排序
 * O(nlog(n))
 * @author lyn
 * @since 2022/11/6 17:52
 */
public class MergeSort {

    public static void process(int[] arr, int l , int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r -l ) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,4,7,2,5,8};
        process(arr, 0 , 5);
        System.out.println(Arrays.toString(arr));
    }
}

/**
 * 小和问题
 */
class SmallSum {
    public static int process(int[] arr, int l , int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r -l ) >> 1);
        return process(arr, l, mid) +
        process(arr, mid + 1, r) +
        merge(arr, l, mid, r);

    }
    private static int  merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,4,2,5};
        System.out.println(process(arr, 0, 4));
    }
}
