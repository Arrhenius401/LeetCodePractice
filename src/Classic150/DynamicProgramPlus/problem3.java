package Classic150.DynamicProgramPlus;

//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
//
//两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
//
//s = s1 + s2 + ... + sn
//t = t1 + t2 + ... + tm
//|n - m| <= 1
//交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
//注意：a + b 意味着字符串 a 和 b 连接。

public class problem3 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();

        if(len1 + len2 != len3){
            return false;
        }

        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;

        for (int i = 1; i < len1+1; i++) {
            if(s1.charAt(i-1) != s3.charAt(i-1)){
                break;
            }
            dp[i][0] = true;
        }

        for (int i = 1; i < len2+1; i++) {
            if(s2.charAt(i-1) != s3.charAt(i-1)){
                break;
            }
            dp[0][i] = true;
        }

        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                 dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                         (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return dp[len1][len2];
    }
}
