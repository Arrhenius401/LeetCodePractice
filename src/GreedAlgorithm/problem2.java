package GreedAlgorithm;

import java.util.HashMap;

public class problem2 {
    public boolean canJump(int[] nums) {
        int max = 0, cur = 0;

        while (cur <= max && cur < nums.length){
            if(max < nums[cur] + cur){
                max = nums[cur] + cur;
            }
            cur++;
        }

        if(max < nums.length-1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        problem2 p = new problem2();

        System.out.println(p.canJump(nums));
    }
}
