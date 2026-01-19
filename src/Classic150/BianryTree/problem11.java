package Classic150.BianryTree;

// 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。

public class problem11 {
    Integer ans = -1;
    Integer cur = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode root, int k) {
        if(root == null){
            return;
        }

        inorder(root.left, k);
        cur++;
        if(cur == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
