package Classic150.DoublePointers;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem5 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);
        for (int first = 0; first < n-2; first++) {
            if(first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int third = n-1;
            int target = -nums[first];
            for (int second = first+1; second < n-1; second++) {
                if(second > first+1 && nums[second] == nums[second-1]){
                    continue;
                }

                while (third > second && nums[second] + nums[third] > target) {
                    third--;
                }

                if(second == third){
                    break;
                }

                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        problem5 p = new problem5();

        System.out.println(p.threeSum(nums));
    }
}
