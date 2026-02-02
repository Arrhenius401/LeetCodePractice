package Classic150.BianryTree;

//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

import java.util.*;

public class problem19 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root != null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> path = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                path.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            ans.add(path);
        }

        return ans;
    }
}
