package DynamicPrograming;

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
