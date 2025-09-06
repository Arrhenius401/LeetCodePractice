package DynamicPrograming;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//你可以认为每种硬币的数量是无限的。

import java.util.Arrays;

public class problem5 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        if(amount == 0){
            return 0;
        }

        Arrays.sort(coins);

        if(coins.length == 0 || amount<coins[0]){
            return -1;
        }

        for(int i=0; i<amount+1; i++){
            dp[i] = -1;
        }

        for(int j=0; j<coins.length && coins[j] <amount+1; j++){
            dp[coins[j]] = 1;
        }

        for(int i=coins[0]; i<amount+1;  i++){
            if(dp[i] > 0){
                for(int j=0; j<coins.length && i+coins[j] <amount+1 && coins[j] <amount+1; j++){
                    int ptr = i+coins[j];
                    if(dp[ptr] == -1){
                        dp[ptr] = dp[i]+1;
                    }else {
                        dp[ptr] = Math.min(dp[ptr], dp[i]+1);
                    }
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {474,83,404,3};
        int amount = 264;
        problem5 p = new problem5();

        System.out.println(p.coinChange(coins, amount));
    }
}
