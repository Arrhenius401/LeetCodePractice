package Classic150.DynamicProgram;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//你可以认为每种硬币的数量是无限的

public class problem4 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for (int i = 1; i < amount+1; i++) {
            dp[i] = -1;
        }

        for (int i = 0; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                int point = i + coins[j];
                if(dp[i] != -1 && point <= amount && point > 0){
                    if(dp[point] != -1) {
                        dp[point] = Math.min(dp[point], dp[i]+1);
                    }else {
                        dp[point] = dp[i] + 1;
                    }
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        problem4 p = new problem4();

        System.out.println(p.coinChange(coins, amount));
    }
}
