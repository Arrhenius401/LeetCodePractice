package Classic150.DynamicProgramPlus;

//给你一个字符串 s，找到 s 中最长的 回文 子串。

public class problem8 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int L = 2; L < n; L++) {
            for (int i = 0; i < n; i++) {
                int j = L + i - 1;
                if(j >= n){
                    break;
                }

                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                } else {
                    if(j - i < 3) {
                        dp[i][j] = true;
                    }else {
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
        problem8 p = new problem8();

        System.out.println(p.longestPalindrome(s));
    }
}
