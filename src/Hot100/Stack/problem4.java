package Hot100.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class problem4 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();

        for (int i=0;i<len;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int pre = stack.pop();
                ans[pre] = i-pre;
            }
            stack.push(i);
        }

        return ans;
    }
}
