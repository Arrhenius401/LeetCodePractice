package Hot100.Hash;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

import java.util.Arrays;

public class problem3 {
    public int longestConsecutive(int[] nums) {
        //检查空值
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int start = nums[0];
        int length = 1;
        int maxLength = 0;

        for(int num : nums){
            if (num == ++start) {
                length++;
            } else{
                if(num != (start-1)){
                    length = 1;
                }
                start = num;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};

        int r = new problem3().longestConsecutive(nums);
        System.out.println(r);
    }
}
