package Classic150.BianryTree;

// 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

public class problem14 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if(root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
}
