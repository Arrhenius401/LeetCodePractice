package BinaryTree;

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

import java.util.*;

public class problem10 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int branch = 1;

        if(root != null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            branch = queue.size();

            for(int i=0;i<branch;i++){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }

                if(i == branch-1){
                    ans.add(node.val);
                }
            }
        }

        return ans;
    }
}
