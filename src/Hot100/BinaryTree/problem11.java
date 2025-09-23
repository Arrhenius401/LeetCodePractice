package Hot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class problem11 {
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        preorder(root, q);
    }

    public void preorder(TreeNode root, Queue<TreeNode> q){
        if(root == null){
            return;
        }

        TreeNode tempRight = root.right;
        TreeNode tempLeft = root.left;

        if(!q.isEmpty()){
            TreeNode n = q.poll();
            n.right = root;
        }

        q.offer(root);
//        root.right = root.left;
        root.left = null;

        preorder(tempLeft, q);
        preorder(tempRight, q);
    }
}
