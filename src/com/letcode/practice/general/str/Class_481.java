package com.letcode.practice.general.str;

/**
 * https://leetcode.cn/problems/magical-string/
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 * <p>
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
 * <p>
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/magical-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lyn
 * @since 2022/10/31 23:35
 */
public class Class_481 {

    public static int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] arr = new char[n];
        arr[0] = '1';
        arr[1] = '2';
        arr[2] = '2';
        int res = 1;
        int a = 2;
        int tail = 3;
        while (tail < n) {
            int num = arr[a] - '0';
            int next = '3' - arr[tail - 1];
            while (num > 0 && tail < n) {
                arr[tail] = (char) ('0' + next);
                if (arr[tail] == '1') {
                    res++;
                }
                tail++;
                num--;
            }
            a++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(magicalString(7));
    }
    //12211221211
}
