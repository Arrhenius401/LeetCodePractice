package Classic150.DynamicProgramPlus;

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

public class problem4 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i > 0 && j > 0){
                    dp[i][j] = matrix[i][j] == '0' ? 0 : Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
                }else{
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans*ans;
    }
}
