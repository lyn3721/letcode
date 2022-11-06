package com.letcode.practice.str;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lyn
 * @since 2022/11/6 12:23
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 * 示例 1：
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 *
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 *
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 */
public class Class_1678 {
    public static String interpret(String command) {
//        char[] chars = command.toCharArray();
//        String a = "";
//        String tmp = "";
//        Deque<Character> deque = new ArrayDeque<>();
//        for (char aChar : chars) {
//            if (aChar == 'G') {
//                a += aChar;
//            } else if (aChar == '(') {
//                deque.push(aChar);
//                tmp += aChar;
//            } else {
//
//                if (aChar == ')') {
//                    deque.pop();
//                    tmp += aChar;
//                    if (tmp.equals("()")) {
//                        a += "o";
//                        tmp = "";
//                    } else {
//                        a += "al";
//                        tmp = "";
//                    }
//                }
//                if (!deque.isEmpty()) {
//                    tmp += aChar;
//
//                }
//            }
//        }
        return command.replace("()", "o").replace("(al)", "al");
//        command.replace("()", "o");
//        command.replace("(al)", "al");
//        return a;
    }


    public static void main(String[] args) {
        String command = "G()(al)";
        String o = command.replace("()", "o");
        System.out.println(o);
//        System.out.println(interpret(command));
    }
}
