package Classic150.Matrix;

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
//
//连接：一个单元格与水平或垂直方向上相邻的单元格连接。
//区域：连接所有 'O' 的单元格来形成一个区域。
//围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
//通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。

public class problem3 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && (i == 0 || i == m-1 || j == 0 || j == n-1)){
                    iter(board, i, j, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void iter(char[][] board, int i, int j, int m, int n) {
        board[i][j] = '1';
        if(i > 0 && board[i-1][j] == 'O'){
            iter(board, i-1, j, m, n);
        }
        if(i < m-1 && board[i+1][j] == 'O'){
            iter(board, i+1, j, m, n);
        }
        if(j > 0 && board[i][j-1] == 'O'){
            iter(board, i, j-1, m, n);
        }
        if(j < n-1 && board[i][j+1] == 'O'){
            iter(board, i, j+1, m, n);
        }
    }
}
