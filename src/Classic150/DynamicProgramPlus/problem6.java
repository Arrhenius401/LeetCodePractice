package Classic150.DynamicProgramPlus;

//给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。

public class problem6 {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        int[] sell = new int[k];

        for (int i = 0; i < k; i++) {
            buy[i] = -prices[0];
            sell[i] = 0;
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                buy[j] = j == 0 ? Math.max(buy[0], -prices[i]) : Math.max(buy[j], sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return sell[k-1];
    }
}
