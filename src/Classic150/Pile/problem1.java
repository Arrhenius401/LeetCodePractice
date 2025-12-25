package Classic150.Pile;

//给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
//
//定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
//
//请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class problem1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{i, 0});
        }

        for (int i = 0; i < k; i++) {
            int[] cur = pq.poll();
            List<Integer> curAns = new ArrayList<>();
            curAns.add(nums1[cur[0]]);
            curAns.add(nums2[cur[1]]);
            ans.add(curAns);

            if(cur[1] + 1 < nums2.length) {
                pq.offer(new int[]{cur[0], cur[1]+1});
            }
        }


        return ans;
    }
}
