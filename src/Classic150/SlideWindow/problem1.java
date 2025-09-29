package Classic150.SlideWindow;

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

import java.util.Arrays;
import java.util.HashMap;

public class problem1 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int sum = Integer.MIN_VALUE;
        int left = 0, right = left;

        // 枚举左边界
        for(; left<n; left++){
            // 初始化sum
            if(left == 0){
                sum = nums[0];
            } else {
                sum = sum - nums[left-1];
            }

            // 枚举右边界
            if(sum <= target){
                while (sum < target && right < n-1){
                    right++;
                    sum += nums[right];
                }

                if(sum >= target){
                    ans = Math.min(ans, right - left + 1);
                }
            } else {
                ans = Math.min(ans, right - left + 1);
                for(; right > left; right--){
                    if(sum-nums[right] < target){
                        ans = Math.min(ans, right - left + 1);
                        break;
                    }
                    sum -= nums[right];
                }
            }
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    // 题目看错，看成等于了
    public int minSubArrayLenEqual(int target, int[] nums) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix.put(sum, i);

            if(prefix.containsKey(sum - target)){
                ans = Math.min(ans, i - prefix.get(sum - target));
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,2,3};
        int target = 6;
        problem1 p = new problem1();

        System.out.println(p.minSubArrayLen(target, nums));
    }
}
