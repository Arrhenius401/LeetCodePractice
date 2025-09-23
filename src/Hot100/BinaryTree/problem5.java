package Hot100.BinaryTree;

public class problem5 {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        //更新ans
        ans = Math.max(ans, left+right+1);
        return Math.max(left, right)+1;
    }
}
