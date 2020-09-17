package com.natsu.leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author shuaishuai.ren
 * @since 2020-09-17
 */
public class LeetCode122 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int pre = prices[0];
        int purchase = 0;
        int profit = 0;
        boolean hold = false;
        for (int i = 1; i < prices.length; i++) {
            final int current = prices[i];
            if (pre == current) {
                continue;
            }
            if (pre < current && !hold) {
                purchase = pre;
                hold = true;
            }
            if (pre > current && hold) {
                profit += (pre - purchase);
                hold = false;
            }
            pre = current;
        }
        if (hold){
            profit += prices[prices.length - 1] - purchase;
        }

        return profit;
    }

    public static void main(String[] args) {

        final int profit = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(profit);
    }

}
