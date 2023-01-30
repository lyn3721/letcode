package com.letcode.practice.swordfingeroffer;

import java.util.ArrayList;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * @author lyn
 * @since 2023/1/18 17:57
 */
public class Offer_04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int k = 0; k < matrix.length; k++) {
            for (int l = matrix[0].length - 1; l > 0; l--) {
                if (matrix[k][l] == target) {
                    return true;
                }
                if (matrix[k][l] < target) {
                    break;
                }

            }
        }
        return false;
    }
}
