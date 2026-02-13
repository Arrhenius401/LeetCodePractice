package Classic150.DynamicProgramPlus;

//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
//
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//删除一个字符
//替换一个字符

public class problem9 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(n * m == 0){
            return n + m;
        }

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int left_down = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }

        return dp[n][m];
    }
}
