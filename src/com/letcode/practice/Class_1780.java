package com.letcode.practice;

/**
 * @author lyn
 * @since 2022/12/9 23:44
 */
public class Class_1780 {
    public static boolean checkPowersOfThree(int n) {
        for(int i = 4; i >= 0 ; i --) {
            double a = Math.pow(3.0, 20);
            if (a <= n) {
                n -= a;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
//        System.out.println(checkPowersOfThree(91));
        int i = 0;
        while (true) {
            i ++;
            if (Math.log10(Math.pow(3.0, i)) > 7) {
                break;
            }

        }
        System.out.println(Math.pow(3.0, 15));
        System.out.println(Math.log10(Math.pow(3.0, i)));
    }
}
