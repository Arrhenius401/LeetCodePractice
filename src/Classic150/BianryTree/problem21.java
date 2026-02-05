package Classic150.BianryTree;

//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//有效 二叉搜索树定义如下：
//
//节点的左子树只包含 严格小于 当前节点的数。
//节点的右子树只包含 严格大于 当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。

import java.util.ArrayList;
import java.util.List;

public class problem21 {
    List<Integer> nums;
    public boolean isValidBST(TreeNode root) {
        nums = new ArrayList<>();
        put(root);

        int cur = nums.get(0);
        boolean isSorted = true;
        for (int i = 1; i < nums.size(); i++) {
            int next = nums.get(i);
            if(next <= cur) {
                isSorted = false;
                break;
            }
            cur = next;
        }

        return isSorted;

    }

    public void put(TreeNode root) {
        if(root == null) {
            return;
        }

        put(root.left);
        nums.add(root.val);
        put(root.right);
    }
}
