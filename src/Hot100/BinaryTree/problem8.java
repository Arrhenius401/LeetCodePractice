package Hot100.BinaryTree;

//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//有效 二叉搜索树定义如下：
//节点的左子树只包含 严格小于 当前节点的数。
//节点的右子树只包含 严格大于 当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。
//注：严格小于不包括等于

import java.util.ArrayList;
import java.util.List;

public class problem8 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> sortVal = new ArrayList<>();
        boolean ans = inorder(root, sortVal);

        return ans;
    }

    public boolean inorder(TreeNode root, List<Integer> sortVal){
        int len = sortVal.size();

        if(root == null){
            return true;
        }

        if(len != 0 && sortVal.get(len-1) >= root.val){
            return false;
        }

        boolean leftRes = inorder(root.left, sortVal);
        len = sortVal.size();
        if(len != 0 && sortVal.get(len-1) >= root.val){
            return false;
        }
        sortVal.add(root.val);
        boolean rightRes = inorder(root.right, sortVal);

        return leftRes && rightRes;
    }
}
