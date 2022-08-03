package com.letcode.queue;

import java.util.Arrays;

/**
 * @author lyn
 * @since 2022/8/3 23:24
 * <p>
 * <p>
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * <p>
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/orderly-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OrderlyQueue {
    /**
     * 解：傻逼hard吓唬人
     * 等于1的时候就一个一个往后排 啥时候最小 啥时候就对
     * 大于一时候直接排序个最小的就完事了
     */
    public static String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        if(k == 1) {
            sb.append(s);
            String smallest = s;
            for (int i = 0; i < s.length(); i++) {
                sb.append(chars[i]);
                sb.deleteCharAt(0);
                if (smallest.compareTo(sb.toString()) > 0) {
                    smallest = sb.toString();
                }
            }
            return smallest;
        }
        Arrays.sort(chars);
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(orderlyQueue("baaca", 3));
    }
}
