package com.letcode.learn.sort;

import java.util.Arrays;

/**
 * 插入排序
 * O(n^2)
 * @author lyn
 * @since 2022/11/5 18:41
 */
public class InsertionSort {
    public static void inserttionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 7, 2, 4, 3, 1};
        System.out.println(Arrays.toString(arr));
        inserttionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
