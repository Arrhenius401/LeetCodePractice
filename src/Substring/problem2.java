package Substring;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//返回 滑动窗口中的最大值 。

import java.util.Comparator;
import java.util.PriorityQueue;

public class problem2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for(int i=0; i<k; i++){
            heap.offer(new int[]{nums[i], i});
        }

        for(int i=k; i<nums.length; i++){
            ans[i-k] = heap.peek()[0];
            while(!heap.isEmpty() && heap.peek()[1] <= i-k){
                heap.poll();
            }
            heap.offer(new int[]{nums[i], i});
        }
        ans[len-1] = heap.poll()[0];

        return ans;
    }

    public static void main(String[] args) {
        problem2 problem2 = new problem2();
        int[] nums = {1, -1};
        int k = 1;
        int[] ans = problem2.maxSlidingWindow(nums, k);
    }
}
