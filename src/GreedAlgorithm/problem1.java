package GreedAlgorithm;

import java.util.Deque;

public class problem1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<len; i++){
            if(prices[i] < minProfit){
                minProfit = prices[i];
            }else {
                int pre = prices[i]  - minProfit;
                if(pre > maxProfit){
                    maxProfit = pre;
                }
            }
        }

        return maxProfit;
    }
}
