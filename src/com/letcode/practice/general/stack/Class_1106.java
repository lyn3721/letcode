package com.letcode.practice.general.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/parsing-a-boolean-expression/
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/parsing-a-boolean-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lyn
 * @since 2022/11/5 15:27
 */
public class Class_1106 {
    public static boolean parseBoolExpr(String expression) {
        char[] chars = expression.toCharArray();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c: chars) {
            if (c == ',') {
                continue;
            } else if (c != ')') {
                deque.push(c);
            } else {
                int t = 0;
                int f = 0;
                while (deque.peek() != '(') {
                    char pop = deque.pop();
                    if (pop == 't') {
                        t++;
                    } else {
                        f++;
                    }
                }
                deque.pop();
                char op = deque.pop();
                switch (op) {
                    case '!' :
                        deque.push(t == 1 ? 'f' : 't');
                        break;
                    case '|' :
                        deque.push(t > 0 ? 't' : 'f');
                        break;
                    case '&' :
                        deque.push(f > 0 ? 'f' : 't');
                        break;
                    default:
                }
            }

        }
        return deque.pop() == 't';
    }


    public static void main(String[] args) {
        System.out.println(parseBoolExpr("|(&(t,f,t),!(t))"));
    }


}
