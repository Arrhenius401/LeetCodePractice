package Array;

//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class problem5 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] <= 0){
                nums[i] = n+2;
            }
        }

        for(int i=0; i<n; i++){
            int ptr = nums[i];
            while(ptr >= 1 && ptr <= n){
                int temp = ptr;
                ptr = nums[ptr-1];
                nums[temp-1] = -1;
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }

    public int firstSolve(int[] nums){
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }

        int ans = 1;
        while (set.contains(ans)){
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        problem5 p = new problem5();

        System.out.println(p.firstMissingPositive(nums));
    }
}
