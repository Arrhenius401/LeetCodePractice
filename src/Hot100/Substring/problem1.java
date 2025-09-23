package Hot100.Substring;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//子数组是数组中元素的连续非空序列。

import java.util.HashMap;

public class problem1 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(pre,1);

        int count = 0;
        for(int i=0;i<nums.length;i++){
            pre += nums[i];
            if(map.containsKey(pre-k)){
                count += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;

    }
}
