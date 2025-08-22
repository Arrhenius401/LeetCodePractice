package DoublePointers;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

public class problem1 {
    public void moveZeroes(int[] nums) {
        int notZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZero++] = nums[i];
            }
        }
        for(int i = notZero; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
