package Classic150.BianryTree;

//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
//差值是一个正数，其数值等于两值之差的绝对值。

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem2 {
    List<Integer> nums = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        preorder(root);
        Collections.sort(nums);

        for (int i = 1; i < nums.size(); i++) {
            ans = Math.min(ans, nums.get(i)-nums.get(i-1));
        }
        return ans;
    }

    private void preorder(TreeNode root){
        if(root == null){
            return;
        }
        nums.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
