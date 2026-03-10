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

import java.util.Arrays;

public class problem7 {
    static final int MOD = 1000000007;
    int[][][] memo;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.memo = new int[zero + 1][one + 1][2];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        this.limit = limit;
        return (dp(zero, one, 0) + dp(zero, one, 1)) % MOD;
    }

    public int dp(int zero, int one, int lastBit) {
        if (zero == 0) {
            return (lastBit == 0 || one > limit) ? 0 : 1;
        } else if (one == 0) {
            return (lastBit == 1 || zero > limit) ? 0 : 1;
        }

        if (memo[zero][one][lastBit] == -1) {
            int res = 0;
            if (lastBit == 0) {
                res = (dp(zero - 1, one, 0) + dp(zero - 1, one, 1))% MOD;
                if (zero > limit) {
                    res = (res - dp(zero - limit - 1, one, 1) + MOD) % MOD;
                }
            } else {
                res = (dp(zero, one - 1, 0) + dp(zero, one - 1, 1)) % MOD;
                if (one > limit) {
                    res = (res - dp(zero, one - limit - 1, 0) + MOD) % MOD;
                }
            }
            memo[zero][one][lastBit] = res % MOD;
        }
        return memo[zero][one][lastBit];
    }
}
