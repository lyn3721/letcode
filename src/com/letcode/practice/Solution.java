package com.letcode.practice;

/**
 * @author lyn
 * @since 2022/7/12 21:01
 */
public class Solution {
    //基本方法
    public static int oddCells(int m, int n, int[][] indices) {
        int[][] cells = new int[m][n];
        int res = 0;
        for (int[] index : indices) {
            for (int i = 0; i < n; i++) {
                cells[index[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                cells[i][index[1]]++;
            }
        }

        for (int[] cellArr : cells) {
            for (int i : cellArr) {
                if (i % 2 > 0) {
                    res++;
                }
            }
        }


        return res;
    }


    //空间优化
    public static int oddCells1(int m, int n, int[][] indices) {
        int res = 0;
        int[] rows = new int[m];
        int[] colls = new int[n];
        for (int[] index : indices) {
            rows[index[0]] ++ ;
            colls[index[1]] ++ ;
        }

        for (int row : rows) {
            for (int coll : colls) {
                if ((row + coll) % 2 > 0) {
                    res ++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] cells = new int[][]{{0,1},{1,1}};
        System.out.println(oddCells1(2, 3, cells));
    }
}
