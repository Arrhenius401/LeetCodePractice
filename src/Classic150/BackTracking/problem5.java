package Classic150.BackTracking;

//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//
//candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//
//对于给定的输入，保证和为 target 的不同组合数少于 150 个。

import java.util.ArrayList;
import java.util.List;

public class problem5 {
    List<List<Integer>> ans;
    List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();

        backtrack(candidates, target, 0, 0);

        return ans;
    }

    public void backtrack(int[] candidates, int target, int curN, int curI) {
        if(curN == target) {
            List<Integer> temp = new ArrayList<>(path);
            ans.add(temp);
            return;
        } else if (curN > target) {
            return;
        }

        for (int i = curI; i < candidates.length; i++) {
            path.add(candidates[i]);
            curN += candidates[i];
            backtrack(candidates, target, curN, i);
            curN -= candidates[i];
            path.removeLast();
        }
    }
}
