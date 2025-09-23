package Hot100.DynamicProgramingPlus;

//给你一个字符串 s，找到 s 中最长的 回文 子串。

public class problem3 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        // 枚举子串长度
        for(int l=2; l<=n; l++){
            // 枚举左边界
            for (int i = 0; i < n; i++) {
                int j = l+i-1;
                if(j >= n){
                    break;
                }

                if(chars[i] != chars[j])
                {
                    dp[i][j] = false;
                    continue;
                }else{
                    if(j-i < 3){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }

            }
        }

        return s.substring(begin, begin+maxLen);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        problem3 p = new problem3();

        System.out.println(p.longestPalindrome(s));
    }
}
