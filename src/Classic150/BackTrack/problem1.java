package Classic150.BackTrack;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
//你可以按 任何顺序 返回答案。

import java.util.ArrayList;
import java.util.List;

public class problem1 {
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        backtrack(k, n, 1);

        return res;
    }

    public void backtrack(int k, int n, int start){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(k, n, i+1);
            path.remove(path.size()-1);
        }
    }
}
