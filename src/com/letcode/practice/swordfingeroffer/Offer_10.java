package com.letcode.practice.swordfingeroffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * @author lyn
 * @since 2023/1/30 19:16
 * 

 */
public class Offer_10 {
    /**
     * @description
     *  * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *  *
     *  * F(0) = 0, F(1)= 1
     *  * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     *  * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *  *
     *  * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *  *
     *  *
     *  *
     *  * 示例 1：
     *  *
     *  * 输入：n = 2
     *  * 输出：1
     *  * 示例 2：
     *  *
     *  * 输入：n = 5
     *  * 输出：5
     */
    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int a = 0;
        int b = 1;
        int sum;
        //从第三位开始算 少算一次
        for (int i = 0; i < n - 1; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return b;

    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 1, 1, 2, 3, 5, 8, 13
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     *
     */
    public static int numWays(int n) {
        if (n == 0) {
             return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 1;
        int sum ;
        for (int i = 0; i < n - 1; i++) {
            sum = (a + b ) % 1000000007;
            a = b;
            b = sum;
        }

        return  b;

    }

    public static void main(String[] args) {
//        System.out.println(fib(5));
        System.out.println(numWays(7));
//        System.out.println(Integer.MAX_VALUE);
    }




}
