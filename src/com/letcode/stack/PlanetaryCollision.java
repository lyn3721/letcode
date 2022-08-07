package com.letcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author lyn
 * @since 2022/7/13 21:17
 *
 * 模拟栈 ：
 * 1. 如果左边>0 右边<0 必爆炸
 * 2. 如果左边<0 右边>0 永远不爆炸
 * 3. 用栈，左边小于零直接进栈，左边大于零右边小于零 判断大小 判断出栈还是入栈
 */
public class PlanetaryCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean isLive = true;
            while(isLive  && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0 ) {
                Integer peek = stack.peek();
                isLive = peek < -asteroid;
                if (-asteroid >= peek) {
                    stack.pop();
                }
            }
            if (isLive) {
                stack.push(asteroid);
            }

        }
        int[] ints = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ints[i] = stack.pop();
        }
        return ints;
    }


    public static void main(String[] args) {
        int[] ints = new int[] {8, -8};
        int[] x = asteroidCollision(ints);
        for (int i : x) {
            System.out.println(i);
        }
    }
}
