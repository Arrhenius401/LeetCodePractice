package Classic150.BianryTree;

//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

import java.util.*;

public class problem5 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isAsc = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentAns = new ArrayList<>();
            if(isAsc){
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    currentAns.add(node.val);
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
            }else{
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollLast();
                    currentAns.add(node.val);
                    if(node.right != null){
                        queue.addFirst(node.right);
                    }
                    if(node.left != null){
                        queue.addFirst(node.left);
                    }
                }
            }

            ans.add(currentAns);
            isAsc = !isAsc;
        }

        return ans;
    }
}
