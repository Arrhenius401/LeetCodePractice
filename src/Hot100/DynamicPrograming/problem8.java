package Hot100.DynamicPrograming;

//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//测试用例的答案是一个 32-位 整数。

public class problem8 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 以索引为i的数结尾的子数组的值
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];
        int ans = nums[0];

        dpMin[0] = dpMax[0] = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i] >= 0){
                dpMax[i] = Math.max(nums[i], nums[i]*dpMax[i-1]);
                dpMin[i] = nums[i]*dpMin[i-1];
                ans = Math.max(ans, dpMax[i]);
            }else {
                dpMax[i] = nums[i]*dpMin[i-1];
                dpMin[i] = Math.min(nums[i], nums[i]*dpMax[i-1]);
                ans = Math.max(ans, dpMax[i]);
            }
        }

        return ans;

    }
}
