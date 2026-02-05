package Classic150.Matrix;

//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

public class problem6 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean zeroM = false, zeroN = false;

        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                zeroM = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0){
                zeroN = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == 0){
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if(matrix[0][j] == 0){
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (zeroM) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (zeroN) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        problem6 p = new problem6();
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        p.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
