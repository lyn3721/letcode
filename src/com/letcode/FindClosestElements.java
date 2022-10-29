package com.letcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lyn
 * @since 2022/8/25 19:13
 */

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 10⁴
 * <p>
 * arr 按 升序 排列
 * -10⁴ <= arr[i], x <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 415 👎 0
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (x < arr[0]) {
            for (int i = 0; i < 4; i++) {
                list.add(arr[i]);
            }
            Collections.sort(list);
            return list;
        } else if (x > arr[arr.length - 1]) {
            for (int i = arr.length - 1; i > 0; i--) {
                list.add(arr[i]);
            }
            Collections.sort(list);
            return list;
        }
        return list;
    }

    public static void main(String[] args) {

    }

}
