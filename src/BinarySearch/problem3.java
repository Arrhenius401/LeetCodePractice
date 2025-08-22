package BinarySearch;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回 [-1, -1]。
//
//你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

import java.util.Arrays;

public class problem3 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = {-1, -1};
        int mid, ansl, ansr;

        if(nums.length == 0){
            return ans;
        }

        while (left <= right) {
            mid = (left+right)/2;

            if(nums[mid] == target){
                ansl = mid - 1;
                ansr = mid + 1;
                while (ansl >=0 && nums[ansl] == target){
                    ansl--;
                }
                while (ansr < nums.length && nums[ansr] == target){
                    ansr++;
                }
                ans[0] = ansl+1;
                ans[1] = ansr-1;
                break;
            } else if (nums[mid] < target) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        problem3 p = new problem3();
        int target = 1;
        int[] nums = {1};

        System.out.println(Arrays.toString(p.searchRange(nums, target)));
    }
}
