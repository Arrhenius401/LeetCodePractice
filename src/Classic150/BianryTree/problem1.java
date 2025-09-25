package Classic150.BianryTree;

//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

public class problem1 {
    String inorder = "", preorder = "";
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String inorderP = "", inorderQ = "";
        String preorderP = "", preorderQ = "";

        inorderP = "";
        inorderFunct(p);
        inorderP = new String(inorder);

        inorder = "";
        inorderFunct(q);
        inorderQ = new String(inorder);

        preorder = "";
        preorderFunct(p);
        preorderP = new String(preorder);

        preorder = "";
        preorderFunct(q);
        preorderQ = new String(preorder);

        return inorderP.equals(inorderQ) && preorderP.equals(preorderQ);
    }

    private void inorderFunct(TreeNode root){
        if(root == null){
            inorder = inorder + "+null";
            return;
        }

        inorderFunct(root.left);
        inorder = inorder + "+" + root.val;
        inorderFunct(root.right);
    }

    private void preorderFunct(TreeNode root){
        if(root == null){
            preorder = preorder + "+null";
            return;
        }

        preorder = preorder + "+" + root.val;
        preorderFunct(root.left);
        preorderFunct(root.right);
    }
}
