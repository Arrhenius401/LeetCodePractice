package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class problem7 {
    List<List<String>> res;
    List<String> path;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        int n = s.length();
        res = new ArrayList<>();
        path = new ArrayList<>();
        dp = new boolean[n][n];

        // 进行预处理
        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }
        preProcess(s);

        // 进行回溯
        backtrack(s, 0);

        return res;
    }

    public void backtrack(String s, int start){
        int n = s.length();

        if(start == n){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<n; i++){
            if(dp[start][i]){
                path.add(s.substring(start, i+1));;
                backtrack(s, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    // 预处理
    public void preProcess(String s){
        int n = s.length();
        // 枚举子串长度
        for(int i=2; i<=n; i++){
            // 枚举左边界
            for(int j=0; (j+i-1)<n; j++){
                // 右边界
                int k = j+i-1;

                if(s.charAt(j) == s.charAt(k)){
                    dp[j][k] = (j == k-1 || dp[j+1][k-1]);
                }

            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        problem7 p = new problem7();

        p.partition(s);
    }
}
