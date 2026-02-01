package Classic150.BianryTree;

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class problem18 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if(root == null) {
            return ans;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.poll();
                if(i == 0){
                    ans.add(node.val);
                }
                if(node.right != null){
                    deque.offer(node.right);
                }
                if(node.left != null){
                    deque.offer(node.left);
                }
            }
        }

        return ans;
    }
}
