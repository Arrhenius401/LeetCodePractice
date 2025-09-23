package Hot100.Array;

//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

import java.util.Arrays;

public class problem4 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int total = 1;
        int zeroNum = 0;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                zeroNum++;
            }
        }

        if(zeroNum == 0){
            for(int i=0; i<n; i++){
                total *= nums[i];
            }
            for(int i=0; i<n; i++){
                ans[i] = total/nums[i];
            }
        } else if (zeroNum == 1) {
            int ptr = 0;
            for(int i=0; i<n; i++){
                if(nums[i] == 0){
                    ptr = i;
                    continue;
                }
                total *= nums[i];
            }

            ans[ptr] = total;
        }

        return ans;
    }


    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int right = 1, left = 1;

        for(int i=n-1; i>=0; i--){
            ans[i] = right;
            right *= nums[i];
        }

        for(int i=0; i<n; i++){
            ans[i] *= left;
            left *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        problem4 p = new problem4();

        System.out.println(Arrays.toString(p.productExceptSelf1(nums)));
    }
}
