package Classic150.BackTracking;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

public class problem6 {
    boolean ans;
    boolean[][] isVisit;
    public boolean exist(char[][] board, String word) {
        this.ans = false;
        int m = board.length, n = board[0].length;
        isVisit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(board, word, i, j, 0);
            }
        }


        return ans;
    }

    public void backtrack(char[][] board, String word, int x, int y, int curIndex) {
        if(curIndex >= word.length()){
            ans = true;
            return;
        }

        int m = board.length, n = board[0].length;
        if(x >= m || x < 0 || y >= n || y < 0 || isVisit[x][y]) {
            return;
        }

        if(board[x][y] == word.charAt(curIndex)) {
            isVisit[x][y] = true;
            backtrack(board, word, x+1, y, curIndex+1);
            backtrack(board, word, x-1, y, curIndex+1);
            backtrack(board, word, x, y+1, curIndex+1);
            backtrack(board, word, x, y-1, curIndex+1);
            isVisit[x][y] = false;
        }

    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "SEE";
        problem6 p = new problem6();

        System.out.println(p.exist(board, word));
    }
}
