package Classic150.BianryTree;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

import java.util.List;

public class problem3 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        TreeNode ans = build(inorder, postorder, 0, n-1 ,0, n-1);

        return ans;
    }

    public TreeNode build(int[] inorder, int[] postorder,
                          int inStart, int inEnd,
                          int postStart, int postEnd) {
         if(inStart == inEnd){
             return new TreeNode(inorder[inStart]);
         } else if (inStart > inEnd) {
             return null;
         }

        int val = postorder[postEnd];
         TreeNode root = new TreeNode(val);
         int inMid = inStart, postMid;

        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == val){
                inMid = i;
                break;
            }
        }

        int  rightLen = inEnd - inMid;
        root.left = build(inorder, postorder, inStart, inMid-1,
                postStart, postEnd-1-inEnd+inMid);
        root.right = build(inorder, postorder, inMid+1, inEnd,
                postEnd-inEnd+inMid, postEnd-1);
        return root;
    }
}
