package Classic150.Kadane;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//子数组是数组中的一个连续部分。

public class problem2 {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int sum = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < n; i++) {
            sum += nums[i];
            ans = Math.max(ans, Math.max(sum, sum - min));
            min = Math.min(min, sum);
        }


        return ans;
    }
}
