package Classic150.Interval;

//给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
//
//在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
//
//返回插入之后的 intervals。
//
//注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。

import java.util.*;

public class problem2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        boolean isAdd = false;

        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];

            // 处理交叉
            if((cur[0] >= newInterval[0] && cur[0] <= newInterval[1]) ||
                    (newInterval[0] >= cur[0] && newInterval[0] <= cur[1])) {
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            } else if(cur[0] < newInterval[0]) {
                ans.add(cur);
            } else {
                if(!isAdd) {
                    ans.add(newInterval);
                    isAdd = true;
                }
                ans.add(cur);
            }
        }

        if(!isAdd) {
            ans.add(newInterval);
        }

        // List.toArray() 返回的是 Object[]，无法直接强制转换为 int[][]，否则会抛出 ClassCastException。
        // 应使用 List.toArray(T[] a) 方法，传入一个与目标类型一致的数组参数，以确保正确转换为 int[][] 类型。
        return ans.toArray(new int[ans.size()][]);
    }
}
