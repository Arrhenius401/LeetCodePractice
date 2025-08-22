package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。

public class problem4 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        Queue<TreeNode> t = new LinkedList<TreeNode>();
        t.offer(left);
        t.offer(right);

        while (!t.isEmpty()){
            right = t.poll();
            left = t.poll();

            if(right == null && left == null){
                continue;
            }
            if(right == null || left == null){
                return false;
            }
            if(right.val != left.val){
                return false;
            }

            t.offer(left.right);
            t.offer(right.left);

            t.offer(left.left);
            t.offer(right.right);
        }

        return true;
    }
}
