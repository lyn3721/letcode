package com.letcode.practice.str;

import java.util.Arrays;

/**
 * 1684. 统计一致字符串的数目
 *给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 *
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 *
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-the-number-of-consistent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lyn
 * @since 2022/11/8 20:22
 */
public class Class_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        for (String word : words) {

            boolean flag = true;
            char[] chars1 = word.toCharArray();
            for (char c : chars1) {
                if (allowed.indexOf(c) < 0){
                    flag = false;
                }
            }
            if (flag) {
                cnt ++;
            }
        }
        return cnt;


    }



}
