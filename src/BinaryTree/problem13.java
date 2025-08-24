package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class problem13 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);

        return ret;
    }

    public int rootSum(TreeNode root, long targetSum){
        int ret = 0;

        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val == targetSum){
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum-val);

        return ret;
    }

    public int pathSum1(TreeNode root, int targetSum){
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer>prefix, long curr, int targetNum){
        if(root == null){
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetNum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetNum);
        ret += dfs(root.right, prefix, curr, targetNum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
