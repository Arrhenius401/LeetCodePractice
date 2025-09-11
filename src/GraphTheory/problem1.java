package GraphTheory;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。

public class problem1 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j< col; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    public void dfs(char[][] grid, int n, int m){
        int row = grid.length;
        int col = grid[0].length;

        if (n < 0 || m < 0 || n >= row || m >= col || grid[n][m] == '0') {
            return;
        }

        // 原陆地被水淹没
        grid[n][m] = '0';
        dfs(grid, n-1, m);
        dfs(grid, n+1, m);
        dfs(grid, n, m-1);
        dfs(grid, n, m+1);

    }
}
