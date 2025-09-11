package GraphTheory;

//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
//
//值 0 代表空单元格；
//值 1 代表新鲜橘子；
//值 2 代表腐烂的橘子。
//每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
//
//返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

import java.util.LinkedList;
import java.util.Queue;

public class problem2 {

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        // 计数新鲜橘子数量
        int freshNum = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    freshNum++;
                } else if (grid[i][j] == 2) {
                    rowQueue.offer(i);
                    colQueue.offer(j);
                }
            }
        }

        // 计数腐烂橘子数量
        int infectNum = 0;
        int ans = 0;
        while(!rowQueue.isEmpty()){
            boolean isChange = false;
            int badNum = rowQueue.size();

            for(int i=0; i<badNum; i++){
                int r = rowQueue.poll();
                int c = colQueue.poll();

                if(r-1 >= 0 && r-1 < row && grid[r-1][c] == 1){
                    isChange = true;
                    rowQueue.offer(r-1);
                    colQueue.offer(c);
                    grid[r-1][c] = 2;
                    infectNum++;
                }

                if(r+1 >= 0 && r+1 < row && grid[r+1][c] == 1){
                    isChange = true;
                    rowQueue.offer(r+1);
                    colQueue.offer(c);
                    grid[r+1][c] = 2;
                    infectNum++;
                }

                if(c-1 >= 0  && c-1 < col && grid[r][c-1] == 1){
                    isChange = true;
                    rowQueue.offer(r);
                    colQueue.offer(c-1);
                    grid[r][c-1] = 2;
                    infectNum++;
                }

                if(c+1 >= 0  && c+1 < col && grid[r][c+1] == 1){
                    isChange = true;
                    rowQueue.offer(r);
                    colQueue.offer(c+1);
                    grid[r][c+1] = 2;
                    infectNum++;
                }
            }

            if(isChange){
                ans++;
            }else {
                break;
            }
        }

        if(infectNum != freshNum){
            return -1;
        }else {
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        problem2 p = new problem2();

        System.out.println(p.orangesRotting(grid));
    }


}
