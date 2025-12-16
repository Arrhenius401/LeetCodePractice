package Classic150.BFS;

//给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）的每一行改变方向。
//
//你一开始位于棋盘上的方格  1。每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
//
//选定目标方格 next ，目标方格的编号在范围 [curr + 1, min(curr + 6, n2)] 。
//该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
//传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
//当玩家到达编号 n2 的方格时，游戏结束。
//如果 board[r][c] != -1 ，位于 r 行 c 列的棋盘格中可能存在 “蛇” 或 “梯子”。那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格不是任何蛇或梯子的起点。
//
//注意，玩家在每次掷骰的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
//
//举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。（简单来说，类似飞行棋，玩家掷出骰子点数后移动对应格数，遇到单向的路径（即梯子或蛇）可以直接跳到路径的终点，但如果多个路径首尾相连，也不能连续跳多个路径）
//返回达到编号为 n2 的方格所需的最少掷骰次数，如果不可能，则返回 -1。

import java.util.LinkedList;
import java.util.Queue;

public class problem1 {
    public int oldSnakesAndLadders(int[][] board) {
        int n = board.length;
        int[] dp = new int[n*n];

        for (int i = 1; i < n*n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;                                                                                                                                                     ;

        for (int i = 0; i < n*n; i++) {
            if(dp[i] == Integer.MAX_VALUE){
                continue;
            }

            for (int j = 0; j < 6; j++) {
                int ptr = i + j + 1;
                if(ptr >= n*n){
                    break;
                }

                int t1 = ptr % n;
                int t2 = ptr / n;
                int r = n-1-t2;
                int c = t2%2 == 0 ? t1 : n-1-t1;
                if(board[r][c] != -1){
                    dp[board[r][c]-1] = Math.min(dp[board[r][c]-1], dp[i] + 1);
                }else{
                    dp[ptr] = Math.min(dp[ptr], dp[i] + 1);
                }
            }
        }

        return dp[n*n-1] == Integer.MAX_VALUE ? -1 : dp[n*n-1];
    }

    public int anotherOldSnakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();

        int step = 0;
        queue.offer(0);
        while (!queue.isEmpty() && step <= n*n/6+1) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                int node = queue.poll();
                if(node == n*n-1){
                    return step;
                }

                // 遍历后续六点
                for (int j = 0; j < 6; j++) {
                    int ptr = node + j + 1;
                    if(ptr >= n*n){
                        break;
                    }

                    int t1 = ptr % n;
                    int t2 = ptr / n;
                    int r = n-1-t2;
                    int c = t2%2 == 0 ? t1 : n-1-t1;
                    if(board[r][c] != -1){
                        queue.offer(board[r][c]-1);
                    }else if(board[r][c] == -1){
                        queue.offer(ptr);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[n*n];

        int step = 0;
        queue.offer(0);
        while (!queue.isEmpty() && step <= n*n/6+1) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                int node = queue.poll();
                if(node == n*n-1){
                    return step;
                }

                // 遍历后续六点
                for (int j = 0; j < 6; j++) {
                    int ptr = node + j + 1;
                    if(ptr >= n*n){
                        break;
                    }

                    int t1 = ptr % n;
                    int t2 = ptr / n;
                    int r = n-1-t2;
                    int c = t2%2 == 0 ? t1 : n-1-t1;
                    if(board[r][c] != -1){
                        queue.offer(board[r][c]-1);
                    }else if(board[r][c] == -1){
                        queue.offer(ptr);
                        isVisit[ptr] = true;
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,46,47,-1,-1,-1},
                {51,-1,-1,63,-1,31,21,-1},
                {-1,-1,26,-1,-1,38,-1,-1},
                {-1,-1,11,-1,14,23,56,57},
                {11,-1,-1,-1,49,36,-1,48},
                {-1,-1,-1,33,56,-1,57,21},
                {-1,-1,-1,-1,-1,-1,2,-1},
                {-1,-1,-1,8,3,-1,6,56}};
        problem1 p = new problem1();

        System.out.println(p.snakesAndLadders(board));
    }
}
