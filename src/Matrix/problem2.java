package Matrix;

import java.util.*;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

public class problem2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int pointRowF = 0, pointRowB = m-pointRowF-1;
        int pointColL = 0, pointColR = n-pointColL-1;
        boolean isAdd = false;

        while (pointColL <= pointColR && pointRowF <= pointRowB){
            // 向右移动
            for(int i=pointColL; i<=pointColR; i++){
                result.add(matrix[pointRowF][i]);
                isAdd = true;
            }
            pointRowF++;
            if(!isAdd){
                break;
            }else {
                isAdd = false;
            }

            // 向下移动
            for(int j=pointRowF; j<=pointRowB; j++){
                result.add(matrix[j][pointColR]);
                isAdd = true;
            }
            pointColR--;
            if(!isAdd){
                break;
            }else {
                isAdd = false;
            }

            // 向左移动
            for(int i=pointColR; i>=pointColL; i--){
                result.add(matrix[pointRowB][i]);
                isAdd = true;
            }
            pointRowB--;
            if(!isAdd){
                break;
            }else {
                isAdd = false;
            }

            // 向上移动
            for(int j=pointRowB; j>=pointRowF; j--){
                result.add(matrix[j][pointColL]);
                isAdd = true;
            }
            pointColL++;
            if(!isAdd){
                break;
            }else {
                isAdd = false;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        problem2 p = new problem2();

        System.out.println(p.spiralOrder(matrix));
    }
}
