package Hot100.BackTracking;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

public class problem6 {
    String path;
    boolean[][] status;
    boolean isFind;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        status = new boolean[m][n];
        path = "";
        isFind = false;

        // 查找第一个对应的字符
        for (int i=0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    status[i][j] = true;
                    path += board[i][j];
                    backtrack(board, word, i, j);
                    path = path.substring(0, path.length()-1);
                    status[i][j] = false;
                    if(isFind) return isFind;
                }

            }
        }



        return isFind;
    }

    public void backtrack(char[][] board, String word, int startRow, int startCol){
        if(word.equals(path)){
            isFind = true;
            return;
        }

        for(int i=0; i<4; i++){
            int pointRow = startRow;
            int pointCol = startCol;

            if(i == 0){
                // 上
                pointRow--;
            } else if (i == 1) {
                // 下
                pointRow++;
            } else if (i == 2) {
                // 左
                pointCol--;
            } else {
                // 右
                pointCol++;
            }

            if(pointRow >= 0 && pointRow < board.length &&
            pointCol >= 0 && pointCol < board[0].length &&
            !status[pointRow][pointCol] && board[pointRow][pointCol] == word.charAt(path.length())){
                status[pointRow][pointCol] = true;
                path += board[pointRow][pointCol];
                backtrack(board, word, pointRow, pointCol);
                status[pointRow][pointCol] = false;
                path = path.substring(0, path.length()-1);
            }

        }
    }

    public static void main(String[] args) {
        char[][] c = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String s = "ABCCED";
        problem6 p = new problem6();

        System.out.println(p.exist(c, s));
    }
}
