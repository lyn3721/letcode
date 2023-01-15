package com.letcode.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyn
 * @since 2022/7/11 20:32
 */
public class MagicDictionary {
    private List<String> list;
//    Trie trie;

    public MagicDictionary() {
        list = new ArrayList<>();
    }
    public void buildDict(String[] dictionary) {
        List<String> strings = Arrays.asList(dictionary);
        list.addAll(strings);
    }

    public boolean search(String searchWord) {
        int j = 0;
        for (String s : list) {
            if (s.length() == searchWord.length()) {
                char[] chars = searchWord.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != s.charAt((i))) {
                        j ++;
                    }
                }
                if (j == 1) {
                    break;
                }
            }
            j = 0;

        }
        return j == 1;
    }

    /**
     * ["MagicDictionary", "buildDict", "search", "search", "search", "search", "search"]
     * [[], [["hello","hallo","leetcode","judge"]], ["hello"], ["hallo"], ["hell"], ["leetcodd"], ["juage"]]
     * @param args
     */
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] words = new String[] {"hello","hallo","leetcode","judge"};
        magicDictionary.buildDict(words);
//        System.out.println(magicDictionary.search("hello"));
//        System.out.println(magicDictionary.search("hallo"));
//        System.out.println(magicDictionary.search("hhllo"));
//        System.out.println(magicDictionary.search("hell"));
//        System.out.println(magicDictionary.search("leetcodd"));
        System.out.println(magicDictionary.search("juage"));

    }
}
