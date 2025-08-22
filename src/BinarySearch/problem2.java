package BinarySearch;

//给你一个满足下述两条属性的 m x n 整数矩阵：
//
//每行中的整数从左到右按非严格递增顺序排列。
//每行的第一个整数大于前一行的最后一个整数。
//给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。

public class problem2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //在 Java 中，获取二维数组的行数和列数可以通过数组的length属性来实现：
        //获取行数：直接使用二维数组变量的length属性，它返回的是数组中一维数组的个数，即行数。
        //获取列数：需要先指定具体的行索引，然后通过二维数组名[行索引].length来获取该行的列数。
        //注意：Java 中的二维数组可以是不规则的（每行的列数可以不同），所以通常需要指定具体行来获取列数。
        int h = matrix.length;
        int l = matrix[0].length;

        for(int i=0; i<h; i++){
            if(target >= matrix[i][0] && target <= matrix[i][l-1]){
                int left = 0;
                int right = l-1;

                while (left <= right){
                    int mid = (left+right)/2;
                    if(matrix[i][mid] == target){
                        return true;
                    }else if(matrix[i][mid] < target){
                        left = mid+1;
                    }else {
                        right = mid-1;
                    }
                }
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int target = 1;
        problem2 p = new problem2();

        System.out.println(p.searchMatrix(matrix, target));
    }
}
