package com.letcode.practice.swordfingeroffer;

/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * @author lyn
 * @since 2023/1/30 23:04
 */
public class Offer_63 {
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minProfit) {
                minProfit = price;
            } else if (price - minProfit > maxProfit) {
                maxProfit = price - minProfit;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
