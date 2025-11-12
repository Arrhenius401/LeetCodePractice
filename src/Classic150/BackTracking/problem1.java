package Classic150.BackTracking;

//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

import java.util.*;

public class problem1 {

    // 结果
    List<List<String>> solutions = new ArrayList<List<String>>();
    // 列判断
    Set<Integer> columns = new HashSet<>();
    // 斜线判断
    Set<Integer> diagonals1 = new HashSet<>();
    Set<Integer> diagonals2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(queens, n, 0);
        return solutions;
    }

    public void backtrack(int[] queens, int n, int row){
        if(row == n){
            List<String> borad = generatedBoard(queens, n);
            solutions.add(borad);
        }else{
            for (int i = 0; i < n; i++) {
                // 检查是否能安插
                if(columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)){
                    continue;
                }

                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(queens, n, row+1);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generatedBoard(int[] queens, int n){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }

        return board;
    }
}
