package Classic150.Interval;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class problem4 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int cur = 0;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 1; i < n; i++) {
            int[] curInter = intervals[cur];
            int[] nextInter = intervals[i];

            if((curInter[0] >= nextInter[0] && curInter[0] <= nextInter[1]) ||
                nextInter[0] >= curInter[0] && nextInter[0] <= curInter[1]) {
                curInter[0] = Math.min(curInter[0], nextInter[0]);
                curInter[1] = Math.max(curInter[1], nextInter[1]);
            } else {
                ans.add(curInter);
                cur = i;
            }
        }

        ans.add(intervals[cur]);

        int[][] res = ans.toArray(new int[0][0]);

        return res;
    }
}
