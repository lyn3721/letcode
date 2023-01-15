package com.letcode.practice.general;

/**
 * 640. 求解方程
 *
 * @author lyn
 * @since 2022/8/10 23:28
 */
public class Solve_the_equation {
    public String solveEquation(String equation) {
        String regex = "[-+]?\\d+(?:\\.\\d+)?";
        String[] split = equation.replace("-", "+-").split("=");
        String s1 = split[0];
        String s2 = split[1];
        String[] split1 = s1.split("\\+");
        String[] split2 = s2.split("\\+");
        int num1 = 0;
        int coefficient = 0;
        int num2 = 0;
        int coefficient2 = 0;
        for (String s : split1) {
            if ("".equals(s)) {
                continue;
            }
            if (s.matches(regex)) {
                num1 += Integer.parseInt(s);
            } else {
                String x = s.replace("x", "");
                if ("-".equals(x)) {
                    coefficient -= 1;
                } else if ("".equals(x)) {
                    coefficient += 1;
                } else {

                    coefficient += Integer.parseInt(x);
                }
            }
        }
        for (String s : split2) {
            if ("".equals(s)) {
                continue;
            }
            if (s.matches(regex)) {
                num1 -= Integer.parseInt(s);
            } else {
                String x = s.replace("x", "");
                if ("-".equals(x)) {
                    coefficient += 1;
                } else if ("".equals(x)) {
                    coefficient -= 1;
                } else {

                    coefficient -= Integer.parseInt(x);
                }
            }
        }
        int sum = num1 + num2;
        int coefficients = coefficient + coefficient2;
        if (coefficients == 0) {
            return sum == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + sum / -(coefficients);
    }
}
