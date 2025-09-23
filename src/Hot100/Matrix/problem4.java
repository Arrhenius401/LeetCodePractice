package Hot100.Matrix;

//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。

public class problem4 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left, right;

        for(int i=0; i<m; i++){
            left = 0;
            right = n-1;

            if(target < matrix[i][left]){
                break;
            } else if (target > matrix[i][right]) {
                continue;
            }

            while(left <= right){
                int mid = (left+right)/2;

                if(matrix[i][mid] == target){
                    return true;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
