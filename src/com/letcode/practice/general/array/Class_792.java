package com.letcode.practice.general.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 792. 匹配子序列的单词数
 *
 * @author lyn
 * @since 2022/11/17 19:12
 * <p>
 * 给定字符串 s和字符串数组words, 返回words[i]中是s的子序列的单词个数。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s都只由小写字母组成。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-matching-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Class_792 {
    public static int numMatchingSubseq(String s, String[] words) {
        int num = words.length;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (String word : words) {
            char[] arr = word.toCharArray();
            Map<Character, Integer> map1 = new HashMap<>(map) ;
            for (char a : arr) {
                Integer integer = map1.getOrDefault(a, 0);
                if (integer > 0) {
                    map1.put(a, integer - 1);
                } else {
                    num --;
                    break;
                }
            }
        }
        return num;
    }


    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String[] strArr = new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(numMatchingSubseq(s, strArr));
    }
}
