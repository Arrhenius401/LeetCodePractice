package Classic150.BackTrack;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。

public class problem2 {
    int ans;
    public int totalNQueens(int n) {
        this.ans = 0;
        boolean[] col = new boolean[n];
        boolean[] lean1 = new boolean[n * 2 - 1];
        boolean[] lean2 = new boolean[n * 2 - 1];

        backtrack(0, n, col, lean1, lean2);

        return ans;
    }

    public void backtrack(int cur, int n, boolean[] col, boolean[] lean1, boolean[] lean2) {
        if(cur == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            int ptr1 = n + i - cur - 1;
            int ptr2 = i + cur;
            if(!col[i] && !lean1[ptr1] && !lean2[ptr2]) {
                col[i] = true;
                lean1[ptr1] = true;
                lean2[ptr2] = true;

                backtrack(cur+1, n, col, lean1, lean2);

                col[i] = false;
                lean1[ptr1] = false;
                lean2[ptr2] = false;
            }
        }
    }
}
