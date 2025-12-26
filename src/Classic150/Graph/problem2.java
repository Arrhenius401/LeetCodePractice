package Classic150.Graph;

//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
//
//例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
//返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] preNum = new int[numCourses];
        boolean[] isVisit = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            preNum[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(preNum[i] == 0) {
                queue.offer(i);
                ans.add(i);
                isVisit[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> curList = graph.get(cur);

            for (int num: curList) {
                preNum[num]--;
                if(preNum[num] == 0 && !isVisit[num]) {
                    queue.offer(num);
                    ans.add(num);
                }
            }
        }

        return ans.size() == numCourses ? ans.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
}
