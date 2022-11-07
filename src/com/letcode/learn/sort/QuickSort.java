package com.letcode.learn.sort;

import java.util.Arrays;

/**
 * 快速排序
 * O(nlog(n))
 * @author lyn
 * @since 2022/11/6 21:30
 */
public class QuickSort {
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap (arr, l + (int)(Math.random() * (r - l + 1)), r);
            int [] p = partition(arr, l, r);
            // < 区
            quickSort(arr, l, p[0] -1);
            // > 区
            quickSort(arr,  p[1] + 1, r);

        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        //< 区右边界
        int less = l - 1;
        // > 区左边界
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r] ) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r] ) {
                swap(arr, --more, l);
            } else  {
                l ++;
            }
        }
        swap(arr, more, r);
        return new int[] {less + 1, more};
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
//        arr[l] = arr[r] ^ arr[l];
//        arr[r] = arr[r] ^ arr[l];
//        arr[l] = arr[r] ^ arr[l];
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1,2,4,6,3,2,1,4,6};
        quickSort(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
    }
}
