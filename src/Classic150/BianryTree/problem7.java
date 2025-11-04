package Classic150.BianryTree;

//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//每条从根节点到叶节点的路径都代表一个数字：
//
//例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
//计算从根节点到叶节点生成的 所有数字之和 。
//
//叶节点 是指没有子节点的节点。

import java.util.HashMap;
import java.util.Set;

public class problem7 {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        HashMap<TreeNode, Integer> map = new HashMap<>();
        calculate(root, 0, map);
        int sum = 0;
        Set<TreeNode> set = map.keySet();
        for (TreeNode node : set){
            sum += map.get(node);
        }

        return sum;
    }

    private void calculate(TreeNode node, int sum, HashMap<TreeNode, Integer> map){
        if(node == null){
            return;
        }

        sum *= 10;
        sum += node.val;
        if(node.left == null && node.right == null){
            map.put(node, sum);
            return;
        }

        if(node.right != null){
            calculate(node.right, sum, map);
        }

        if(node.left != null){
            calculate(node.left, sum, map);
            return;
        }
    }
}
