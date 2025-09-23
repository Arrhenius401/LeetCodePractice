package Hot100.Array;

import java.util.Arrays;

public class problem2 {
    public int[][] merge(int[][] intervals) {
        int row = intervals.length;
        int ansRow = 0;
        int[] status = new int[row];

        for(int i=0; i<row; i++){
            status[i] = i;
        }

        for(int i=0; i<row; i++){
            for(int j=i+1; j<row; j++){
                // 寻找父结点
                int jParent = j;
                while (status[jParent] != jParent){
                    jParent = status[jParent];
                }
                int iParent = i;
                while (status[iParent] != iParent){
                    iParent = status[iParent];
                }

                if((intervals[jParent][0] <= intervals[iParent][1] && intervals[jParent][0] >= intervals[iParent][0]) ||
                        (intervals[iParent][0] <= intervals[jParent][1] && intervals[iParent][0] >= intervals[jParent][0])){
                    intervals[iParent][0] = intervals[jParent][0] = intervals[i][0] = intervals[j][0] = Math.min(intervals[iParent][0], intervals[jParent][0]);
                    intervals[iParent][1] = intervals[jParent][1] = intervals[i][1] = intervals[j][1] = Math.max(intervals[iParent][1], intervals[jParent][1]);
                    status[i] = status[j] = status[iParent] = status[jParent] = Math.min(iParent, jParent);
                }
            }
        }

        for(int i=0; i<row; i++){
            if(status[i] == i){
                ansRow++;
            }
        }

        int[][] ans = new int[ansRow][2];
        int ptr = 0;
        for(int i=0; i<row; i++){
            if(status[i] == i){
                ans[ptr][0] = intervals[i][0];
                ans[ptr][1] = intervals[i][1];
                ptr++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{2,3},{4,6},{5,7},{3,4}};
//                {{2,3},{3,4},{5,5},{4,5},{5,6},{2,3},{4,6},{0,0}};
//                {{0,0},{1,2},{5,5},{2,4},{3,3},{5,6},{5,6},{4,6},
//                {0,0},{1,2},{0,2},{4,5}};
        problem2 p = new problem2();

        for(int[] array : p.merge(nums)){
            System.out.println(Arrays.toString(array));
        }

    }
}
