package Classic150.Graph;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
//在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//
//例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem5 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] preClass = new boolean[numCourses][numCourses];
        List<Integer> isVisit = new ArrayList<>();
        Stack<Integer> isEmpty = new Stack<>();
        int[] preNum = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] curPre = prerequisites[i];
            preClass[curPre[0]][curPre[1]] = true;
            preNum[curPre[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if(preNum[i] == 0){
                isEmpty.push(i);
                isVisit.add(i);
            }
        }

        while (!isEmpty.isEmpty()) {
            int curNode = isEmpty.pop();
            for (int i = 0; i < numCourses; i++) {
                if(preClass[i][curNode]) {
                    preNum[i]--;
                    if(preNum[i] == 0){
                        isEmpty.push(i);
                        isVisit.add(i);
                    }
                }
            }
        }



        return isVisit.size() == numCourses;
    }
}
