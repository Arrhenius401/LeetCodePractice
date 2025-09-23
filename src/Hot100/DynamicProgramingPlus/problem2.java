package Hot100.DynamicProgramingPlus;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。

public class problem2 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            dp[i][0] = (i==0 ? grid[i][0] : grid[i][0] + dp[i-1][0]);
        }

        for(int j=0; j<m; j++){
            dp[0][j] = (j==0 ? grid[0][j] : grid[0][j] + dp[0][j-1]);
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[n-1][m-1];
    }
}
