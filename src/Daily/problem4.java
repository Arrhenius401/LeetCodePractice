package Daily;

//给你一个二进制字符串 s 。你可以按任意顺序执行以下两种操作任意次：
//
//类型 1 ：删除 字符串 s 的第一个字符并将它 添加 到字符串结尾。
//类型 2 ：选择 字符串 s 中任意一个字符并将该字符 反转 ，也就是如果值为 '0' ，则反转得到 '1' ，反之亦然。
//请你返回使 s 变成 交替 字符串的前提下， 类型 2 的 最少 操作次数 。
//
//我们称一个字符串是 交替 的，需要满足任意相邻字符都不同。
//
//比方说，字符串 "010" 和 "1010" 都是交替的，但是字符串 "0100" 不是。

public class problem4 {
    public int minFlips(String s) {
        int n = s.length();
        int[][] pre = new int[n][2];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            pre[i][0] = (i == 0 ? 0 : pre[i-1][1]) + (ch == '1' ? 1 : 0);
            pre[i][1] = (i == 0 ? 0 : pre[i-1][0]) + (ch == '0' ? 1 : 0);
        }

        int ans = Math.min(pre[n-1][0], pre[n-1][1]);
        if(n % 2 == 1){
            int[][] suf = new int[n][2];
            for (int i = n-1; i >= 0; i--) {
                char ch = s.charAt(i);
                suf[i][0] = (i == n-1 ? 0 : suf[i + 1][1]) + (ch == '1' ? 1 : 0);
                suf[i][1] = (i == n-1 ? 0 : suf[i + 1][0]) + (ch == '0' ? 1 : 0);

            }

            for (int i = 0; i < n - 1; i++) {
                ans = Math.min(ans, pre[i][0] + suf[i+1][0]);
                ans = Math.min(ans, pre[i][1] + suf[i+1][1]);
            }
        }

        return ans;
    }
}
