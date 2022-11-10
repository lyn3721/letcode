package com.letcode.learn.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author lyn
 * @since 2022/11/7 22:03
 * <p>
 * <p>
 * <p>
 * parent = ( child - 1 ) / 2
 * left_child = parent * 2 + 1
 * right_child = parent * 2 + 2
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 向上交换
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 向下交换
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;

            largest = arr[largest] > arr[index] ? largest : index;
            if (index == largest) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int index, int i) {
        int tmp = 0;
        tmp = arr[index];
        arr[index] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,7,8,23,4,3,1,3,4,2,5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
