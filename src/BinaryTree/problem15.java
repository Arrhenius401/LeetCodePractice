package BinaryTree;

//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//路径和 是路径中各节点值的总和。
//
//给你一个二叉树的根节点 root ，返回其 最大路径和 。

import java.util.HashMap;

public class problem15 {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        calculate(root);

        return max;
    }

    public int calculate(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = calculate(root.left);
        int rightSum = calculate(root.right);
        int maxSum = Math.max(leftSum, rightSum);

        max = Math.max(max,
                Math.max(root.val+leftSum,
                        Math.max(root.val+rightSum,
                                Math.max(root.val, root.val+leftSum+rightSum))) );

        // 考虑负值
        return Math.max(root.val,  maxSum+root.val);
    }
}
