package Hot100.BinaryTree;

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

public class problem3 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode root){
        if(root == null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        reverse(root.left);
        reverse(root.right);

    }
}
