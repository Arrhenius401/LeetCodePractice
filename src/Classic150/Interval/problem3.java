package Classic150.Interval;

//有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
//
//一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
//
//给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。

import java.util.*;

public class problem3 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            // 比较器返回值规则：
            // 返回负数：a 排在 b 前面（升序）；
            // 返回正数：a 排在 b 后面（降序）；
            // 返回 0：a 和 b 顺序不变。
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        Deque<int[]> stack = new ArrayDeque<>();
        stack.addFirst(points[0]);
        for (int i = 1; i < points.length; i++) {
            int[] cur = stack.poll();
            if((cur[0] >= points[i][0] && cur[0] <= points[i][1]) ||
            points[i][0] >= cur[0] && points[i][0] <= cur[1]) {
                cur[0] = Math.max(cur[0], points[i][0]);
                cur[1] = Math.min(cur[1], points[i][1]);
                stack.addFirst(cur);
            } else {
                stack.addFirst(cur);
                stack.addFirst(points[i]);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        problem3 p = new problem3();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};

        System.out.println(p.findMinArrowShots(points));
    }
}
