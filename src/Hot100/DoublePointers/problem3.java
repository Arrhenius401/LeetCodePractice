package Hot100.DoublePointers;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//注意：答案中不可以包含重复的三元组。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length;i++){
            //跳过重复元素
            if(i>0 && nums[i] == nums[i-1]) continue;
            if(nums[i] > 0) break;

            //设置双指针
            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }else if(sum > 0){
                    right--;
                }else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    //去除重复元素
                    while (left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left<right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        List<List<Integer>> res = new problem3().threeSum(nums);
    }
}
