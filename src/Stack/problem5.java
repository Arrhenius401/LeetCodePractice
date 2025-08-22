package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class problem5 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];

        Deque<Integer> stack = new LinkedList<>();

        //更新左侧壁垒
        for(int i=0; i<len; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 :stack.peek());
            stack.push(i);
        }

        //更新右侧壁垒
        stack.clear();
        for(int i=len-1; i>=0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? len : stack.peek());
            stack.push(i);
        }

        //计算矩形面积
        int ans = 0;
        for(int i=0; i<len;i++){
            ans = Math.max(ans, (right[i] - left[i] -1)*heights[i]);
        }

        return ans;
    }
}
