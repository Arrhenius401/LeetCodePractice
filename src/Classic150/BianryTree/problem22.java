package Classic150.BianryTree;

//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。

public class problem22 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = build(nums, left, mid-1);
        node.right = build(nums, mid + 1, right);

        return node;
    }
}
