package BinaryTree;

import java.util.Arrays;

public class problem12 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildNode(preorder, inorder);
        return root;
    }

    public TreeNode buildNode(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        } else if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int nodeVal = preorder[0];
        int mid = -1;

        for(int i=0;i< inorder.length;i++){
            if(inorder[i] == nodeVal){
                mid = i;
                break;
            }
        }

        int[] subPreLeft = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] subPreRight = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] subInLeft = Arrays.copyOfRange(inorder, 0, mid);
        int[] subInRight = Arrays.copyOfRange(inorder, mid+1, inorder.length);

        TreeNode root = new TreeNode(nodeVal, buildTree(subPreLeft,subInLeft), buildTree(subPreRight,subInRight));
        return root;
    }
}
