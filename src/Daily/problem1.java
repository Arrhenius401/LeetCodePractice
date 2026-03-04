package Daily;

//给定一个 m x n 的二进制矩阵 mat，返回矩阵 mat 中特殊位置的数量。
//
//如果位置 (i, j) 满足 mat[i][j] == 1 并且行 i 与列 j 中的所有其他元素都是 0（行和列的下标从 0 开始计数），那么它被称为 特殊 位置。

public class problem1 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;;
        int n = mat[0].length;

        int[] count1 = new int[m];
        int[] count2 = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 1){
                    count1[i]++;
                    count2[j]++;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 1 && count1[i] == 1 && count2[j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }
}
