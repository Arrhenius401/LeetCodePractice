package Classic150.BinarySearch;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回 [-1, -1]。
//
//你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

public class problem3 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                int start = mid, end = mid;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                while (end <= nums.length-1 && nums[end] == target) {
                    end++;
                }
                ans[0] = start + 1;
                ans[1] = end - 1;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        problem3 p = new problem3();

        p.searchRange(nums, target);
    }
}
