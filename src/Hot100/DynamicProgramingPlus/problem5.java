package Hot100.DynamicProgramingPlus;

//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
//
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//删除一个字符
//替换一个字符

public class problem5 {
    public int minDistance(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();

        // 存在一个字符串为空串
        if(a*b == 0){
            return a+b;
        }

        int[][] dp = new int[a+1][b+1];
        for (int i = 0; i < a+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < b+1; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<a+1; i++){
            for(int j=1; j<b+1; j++){
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int leftDown = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    leftDown++;
                }

                dp[i][j] = Math.min(leftDown, Math.min(left, down));
            }
        }

        return dp[a][b];
    }
}
