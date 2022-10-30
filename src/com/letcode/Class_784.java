package com.letcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-case-permutation/
 * <p>
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 * @author lyn
 *
 * @since 2022/10/30 15:10
 */
public class Class_784 {
    public static List<String> letterCasePermutation(String s) {
        Deque<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder());
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            StringBuilder cur = queue.peek();
            if (cur.length() == s.length()) {
                list.add(cur.toString());
                queue.poll();
            } else {
                int i = cur.length();
                if (Character.isLetter(s.charAt(i))) {
                    StringBuilder stringBuilder = new StringBuilder(cur);
                    stringBuilder.append((char) (s.charAt(i) ^ 32));
                    queue.offer(stringBuilder);
                }
                cur.append(s.charAt(i));

            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
//        System.out.println(letterCasePermutation("3z4"));
//        System.out.println(letterCasePermutation("Jw"));
        System.out.println((char) ('a' ^ 32));
        System.out.println((char) ('A' ^ 32));
//        System.out.println("a1b2");
    }
}
