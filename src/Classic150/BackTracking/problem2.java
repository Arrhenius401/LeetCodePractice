package Classic150.BackTracking;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

import java.util.*;

public class problem2 {
    List<List<Integer>> ans;
    List<Integer> path;
    Set<Integer> set;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        path = new ArrayList<>();

        backtrack(nums, 0);

        return ans;
    }

    public void backtrack(int[] nums, int round) {
        if(round == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                path.add(nums[i]);

                backtrack(nums, round+1);

                set.remove(nums[i]);
                path.removeLast();
            }
        }
    }
}
