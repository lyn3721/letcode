package com.letcode.practice.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyn
 * @since 2022/11/11 18:38
 * 1704. 判断字符串的两半是否相似
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 *
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 *
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/determine-if-string-halves-are-alike
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Class_1704 {


    public static boolean halvesAreAlike(String s) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add('a');
        objects.add('e');
        objects.add('i');
        objects.add('o');
        objects.add('u');

        String a = s.toLowerCase().substring(0, s.length() / 2);
        String b = s.toLowerCase().substring(s.length() / 2, s.length());
        int i1 = 0;
        int i2 = 0;
        for (char c : a.toCharArray()) {
            if (objects.contains(c)) {
                i1++;
            }
        }

        for (char c : b.toCharArray()) {
            if (objects.contains(c)) {
                i2++;
            }
        }
        return i1 == i2;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
    }


}
