package Classic150.Kadane;

//给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
//
//环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
//
//子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。

public class problem1 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];

        // 对首元素单独处理，避免处理子数组为空的情况
        leftMax[0] = nums[0];
        int leftSum = nums[0];
        int ans = nums[0];
        int pre = nums[0];

        for (int i = 1; i < n; i++) {
            // 1. 不考虑环
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
            // 2. 考虑环，计算左侧前缀
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i-1], leftSum);
        }

        // 从右到左枚举后缀，固定后缀，选择最大前缀
        int rightSum = 0;
        for (int i = n-1; i > 0; i--) {
            rightSum += nums[i];
            ans = Math.max(ans, rightSum + leftMax[i-1]);
        }

        return ans;
    }
}
