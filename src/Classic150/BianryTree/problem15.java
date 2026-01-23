package Classic150.BianryTree;

//给定一个二叉树 root ，返回其最大深度。
//
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

import java.util.Deque;
import java.util.LinkedList;

public class problem15 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int ans = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
            }
            ans++;
        }

        return ans;
    }
}
