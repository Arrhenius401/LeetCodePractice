package Classic150.Matrix;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

import java.util.ArrayList;
import java.util.List;

public class problem4 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] position = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int curP = 0;
        int curX = 0, curY = 0;
        int nextX = curX, nextY = curY;
        boolean isChanged = false;

        while (true){
            if(nextX < m && nextY < n && nextX >= 0 && nextY >= 0 && matrix[nextX][nextY] != Integer.MIN_VALUE) {
                ans.add(matrix[nextX][nextY]);
                matrix[nextX][nextY] = Integer.MIN_VALUE;
                isChanged = false;

                curX = nextX;
                curY = nextY;
            } else {
                if(isChanged){
                    break;
                }else {
                    curP = (curP + 1) % 4;
                    isChanged = true;
                }
            }

            nextX = curX + position[curP][0];
            nextY = curY + position[curP][1];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        problem4 p = new problem4();

        List<Integer> list = p.spiralOrder(matrix);
    }
}
