package Classic150.Array_SubString;

//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
//
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

public class problem20 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] dpf = new int[n];
        int[] dpb = new int[n];

        dpf[0] = 1;
        for (int i = 1; i < n; i++) {
            dpf[i] = nums[i-1] * dpf[i-1];
        }

        dpb[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            dpb[i] = nums[i+1] * dpb[i+1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dpf[i] * dpb[i];
        }

        return ans;
    }
}
