package Hot100.Heap;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class problem2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            //返回负数：表示 o1 应该排在 o2 之前（o1 < o2）
            //返回零：表示 o1 和 o2 相等（o1 == o2）
            //返回正数：表示 o1 应该排在 o2 之后（o1 > o2）
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();;

            queue.offer(new int[]{num, count});
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = queue.poll()[0];
        }

        return ans;

    }
}
