package Hot100.DynamicPrograming;

//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
//完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

public class problem4 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++){
           int minn = Integer.MAX_VALUE;
           for(int j=1; j*j <= i; j++){
                minn = Math.min(minn, dp[i-j*j] + 1);
           }
           dp[i] = minn;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        problem4 p = new problem4();

        System.out.println(p.numSquares(n));
    }
}
