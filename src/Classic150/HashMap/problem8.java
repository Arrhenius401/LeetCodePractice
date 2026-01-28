package Classic150.HashMap;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

import java.util.HashSet;
import java.util.Set;

public class problem8 {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        for (int num: set) {
            if (!set.contains(num-1)) {
                int curLen = 1;
                int curNum = num;

                while (set.contains(curNum+1)) {
                    curLen++;
                    curNum++;
                }

                ans = Math.max(ans, curLen);
            }
        }

        return ans;
    }
}
