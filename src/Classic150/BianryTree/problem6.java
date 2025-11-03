package Classic150.BianryTree;

//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
//
//叶子节点 是指没有子节点的节点。

import java.util.HashMap;

public class problem6 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        HashMap<TreeNode, Integer> map = new HashMap<>();

        if (root == null){
            return false;
        }
        map.put(root, root.val);

        return putPrefix(root, map, targetSum);
    }

    public boolean putPrefix(TreeNode root, HashMap<TreeNode, Integer> map, int targetSum){
        if(root == null){
            return false;
        }

        int prefix = map.get(root);
        if(root.left == null && root.right == null){
            return prefix == targetSum;
        }

        if(root.right != null){
            map.put(root.right, prefix+root.right.val);
        }

        if(root.left != null){
            map.put(root.left, prefix+root.left.val);
        }

        return putPrefix(root.right, map, targetSum) || putPrefix(root.left, map, targetSum);
    }
}
