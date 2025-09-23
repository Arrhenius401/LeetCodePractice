package Hot100.DynamicPrograming;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
//
//左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。

//一遍过
public class problem10 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int i=1; i<n; i++){
            if(s.charAt(i) == ')'){
                for(int j=i-1; j>=0; j--){
                    if(!dp[j] && s.charAt(j) == '('){
                        dp[j] = dp[i] = true;
                        break;
                    } else if (!dp[j] && s.charAt(j) == ')') {
                        break;
                    }
                }
            }
        }

        int max = 0;
        int ptr = -1;

        for(int i=0; i<n; i++){
            if(dp[i] == false){
                ptr = i;
            } else {
                max = Math.max(max, i-ptr);
            }
        }

        return max;
    }
}
