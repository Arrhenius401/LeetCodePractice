package Trick;

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
//
//假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
//
//你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。

public class problem5 {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int finDuplicate1(int[] nums){
        int left = 1;
        int right = nums.length - 1;

        while (left < right){
            int mid = (left + right)/2;
            int count = 0;

            for(int num : nums){
                if(num <= mid){
                    count++;
                }
            }

            if(count > mid){
                right = mid;
            }else {
                left = mid + 1;
            }

        }
        return left;
    }
}
