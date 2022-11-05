package com.letcode.learn.sort;

/**
 * @author lyn
 *
 * 异或运算练习
 * @since 2022/11/5 18:08
 */
public class  XOR_TEST{


    /**
     *  需求 1.
     *  一个数组 里面的数只有一个出现奇数次 其余都是偶数次 找出这个数
     * @param arr  [1,1,1,3,4,5,6,6,5,4,3]
     */
    public static void test1(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println(eor);
    }

    /**
     *  需求 1.
     *  一个数组 里面的数只有两个出现奇数次 其余都是偶数次 找出这个数
     * @param arr  [1,1,1,3,4,5,6,6,5,4,3]
     */
    public static void test2(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        int rightone = eor + (~eor + 1);
        int onlyone = 0;
        for (int i : arr) {
            // 如果等于1会怎么样
            if ((i & rightone) == 0 ) {
                    onlyone ^= i;
            }
        }
        System.out.println(onlyone + "   " + (onlyone ^ eor));
    }
}
