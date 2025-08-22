package BinaryTree;

public class problem7 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        boolean[] isExist = new boolean[len];

        TreeNode ans = create(nums, 0, len-1, isExist);
        return ans;
    }

    public TreeNode create(int[] nums, int left, int right, boolean[] isExist){
        int mid = (left + right)/2;
        TreeNode tn = null;

        if(!isExist[mid]){
            isExist[mid] = true;
            TreeNode leftSon = create(nums, left, mid-1, isExist);
            TreeNode rightSon = create(nums, mid+1, right, isExist);
            tn = new TreeNode(nums[mid], leftSon, rightSon);
        }

        return tn;
    }
}
