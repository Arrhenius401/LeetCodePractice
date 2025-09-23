package Hot100.BackTracking;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

import java.util.ArrayList;
import java.util.List;

public class problem2 {
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        res.add(new ArrayList<>());
        backtrack(nums, 0);

        return res;
    }

    public void backtrack(int[] nums, int start){
        if(start >= nums.length){
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            res.add((new ArrayList<>(path)));
            backtrack(nums, i+1);
            path.remove(path.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        problem2 p = new problem2();

        p.subsets(nums);
    }
}
