package com.letcode.practice.general;

/**
 * @author lyn
 * @since 2022/7/14 19:27
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 *
 * 实现 WordFilter 类：
 *
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 *  
 *
 * 示例：
 *
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
 *  
 * 提示：
 *
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 7
 * 1 <= pref.length, suff.length <= 7
 * words[i]、pref 和 suff 仅由小写英文字母组成
 * 最多对函数 f 执行 104 次调用
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/prefix-and-suffix-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordFilter {
    private String[] strs = new String[0];

    public WordFilter(String[] words) {
        strs = words;

    }

    public int f(String pref, String suff) {
        for (int i = strs.length -1 ; i >= 0; i--) {
            String str = strs[i];
            if (str.startsWith(pref) && str.endsWith(suff)) {
                return i;
            }
        }
        return -1;
    }
}
/**
 * reslove2:
 * class WordFilter {
 *     Trie trie;
 *     String weightKey;
 *
 *     public WordFilter(String[] words) {
 *         trie = new Trie();
 *         weightKey = "##";
 *         for (int i = 0; i < words.length; i++) {
 *             String word = words[i];
 *             Trie cur = trie;
 *             int m = word.length();
 *             for (int j = 0; j < m; j++) {
 *                 Trie tmp = cur;
 *                 for (int k = j; k < m; k++) {
 *                     String key = new StringBuilder().append(word.charAt(k)).append('#').toString();
 *                     if (!tmp.children.containsKey(key)) {
 *                         tmp.children.put(key, new Trie());
 *                     }
 *                     tmp = tmp.children.get(key);
 *                     tmp.weight.put(weightKey, i);
 *                 }
 *                 tmp = cur;
 *                 for (int k = j; k < m; k++) {
 *                     String key = new StringBuilder().append('#').append(word.charAt(m - k - 1)).toString();
 *                     if (!tmp.children.containsKey(key)) {
 *                         tmp.children.put(key, new Trie());
 *                     }
 *                     tmp = tmp.children.get(key);
 *                     tmp.weight.put(weightKey, i);
 *                 }
 *                 String key = new StringBuilder().append(word.charAt(j)).append(word.charAt(m - j - 1)).toString();
 *                 if (!cur.children.containsKey(key)) {
 *                     cur.children.put(key, new Trie());
 *                 }
 *                 cur = cur.children.get(key);
 *                 cur.weight.put(weightKey, i);
 *             }
 *         }
 *     }
 *
 *     public int f(String pref, String suff) {
 *         Trie cur = trie;
 *         int m = Math.max(pref.length(), suff.length());
 *         for (int i = 0; i < m; i++) {
 *             char c1 = i < pref.length() ? pref.charAt(i) : '#';
 *             char c2 = i < suff.length() ? suff.charAt(suff.length() - 1 - i) : '#';
 *             String key = new StringBuilder().append(c1).append(c2).toString();
 *             if (!cur.children.containsKey(key)) {
 *                 return -1;
 *             }
 *             cur = cur.children.get(key);
 *         }
 *         return cur.weight.get(weightKey);
 *     }
 * }
 *
 * class Trie {
 *     Map<String, Trie> children;
 *     Map<String, Integer> weight;
 *
 *     public Trie() {
 *         children = new HashMap<String, Trie>();
 *         weight = new HashMap<String, Integer>();
 *     }
 * }
 */
