package Hot100.BinaryTree;

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class problem9 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> sortVal = new ArrayList<Integer>();

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            sortVal.add(root.val);
            root = root.right;

        }

        return sortVal.get(k-1);
    }

}
