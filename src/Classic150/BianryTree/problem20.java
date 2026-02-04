package Classic150.BianryTree;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

public class problem20 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return trueBuild(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode trueBuild(int[] preorder, int[] inorder, int pre1, int pre2,
                              int in1, int in2) {
        if(Math.max(pre1, pre2) >= preorder.length || Math.max(in1, in2) >= inorder.length ||
            pre1 > pre2 || in1 > in2){
            return null;
        }

        int curVal = preorder[pre1];
        TreeNode node = new TreeNode(curVal);

        if(pre1 == pre2){
            return node;
        }

        int curIndex;
        for (curIndex = in1; curIndex < inorder.length; curIndex++) {
            if(inorder[curIndex] == curVal){
                break;
            }
        }

        int preLen = curIndex - in1;

        node.left = trueBuild(preorder, inorder, pre1 + 1, pre1 + preLen, in1, curIndex - 1);
        node.right = trueBuild(preorder, inorder, pre1 + preLen + 1, pre2, curIndex + 1, in2);

        return node;
    }

    public static void main(String[] args) {
        problem20 problem20 = new problem20();
        int[] preorder = {1,2}, inorder = {1,2};

        TreeNode node = problem20.buildTree(preorder, inorder);
    }
}
