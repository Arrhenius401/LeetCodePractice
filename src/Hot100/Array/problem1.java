package Hot100.Array;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//子数组是数组中的一个连续部分。

public class problem1 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;

        for(int i:nums){
            sum += i;
            ans = Math.max(ans, sum-min);
            min = Math.min(min, sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1};
        problem1 p = new problem1();

        System.out.println(p.maxSubArray(nums));
    }
}
