package Daily;

//给你 3 个正整数 zero ，one 和 limit 。
//
//一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
//
//0 在 arr 中出现次数 恰好 为 zero 。
//1 在 arr 中出现次数 恰好 为 one 。
//arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。
//请你返回 稳定 二进制数组的 总 数目。
//
//由于答案可能很大，将它对 109 + 7 取余 后返回。

public class problem6 {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final long MOD = 1000000007;
        long[][][] dp = new long[zero + 1][one + 1][2];
        for (int i = 0; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 0; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                if (i > limit) {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1] - dp[i - limit - 1][j][1];
                } else {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                }
                dp[i][j][0] = (dp[i][j][0] % MOD + MOD) % MOD;
                if (j > limit) {
                    dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0] - dp[i][j - limit - 1][0];
                } else {
                    dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0];
                }
                dp[i][j][1] = (dp[i][j][1] % MOD + MOD) % MOD;
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }

}
