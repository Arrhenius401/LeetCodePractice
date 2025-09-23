package Hot100.DynamicProgramingPlus;

//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//
//一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
//

public class problem4 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for(int j=1; j <= m; j++){
                if(chars1[i-1] == chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        problem4 problem4 = new problem4();
        String text1 = "oxcpqrsvwf", text2 = "shmtulqrypy";
        System.out.println(problem4.longestCommonSubsequence(text1, text2));
    }
}
