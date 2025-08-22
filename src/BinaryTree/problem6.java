package BinaryTree;

//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem6 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();
        int branch = 1;

        if(root != null){
            q.offer(root);
        }

        while (q.size() != 0){
            branch = q.size();
            List<Integer> layer = new ArrayList<>();

            for(int i = 0; i<branch; i++){
                TreeNode tn = q.poll();
                layer.add(tn.val);

                if(tn.left != null){
                    q.offer(tn.left);
                }
                if(tn.right != null){
                    q.offer(tn.right);
                }

            }

            ans.add(layer);
        }

        return ans;
    }
}
