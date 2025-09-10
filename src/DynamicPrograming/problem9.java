package DynamicPrograming;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

import java.util.Arrays;

public class problem9 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        if(n < 2){
            return false;
        }

        for(int i=n-1; i>=0; i--){
            sum += nums[i];
        }

        if(sum%2 != 0){
            return false;
        }

        int target =  sum/2;

        boolean[][] dp = new boolean[n][target+1];
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<n; i++){
            int num = nums[i];
            for(int j=1; j<target+1; j++){
                if(num <= j){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][target];
    }
}
