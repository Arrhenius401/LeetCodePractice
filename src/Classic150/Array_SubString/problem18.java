package Classic150.Array_SubString;

//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。

public class problem18 {
    public boolean canJump(int[] nums) {
        int curIndex = 0;
        int maxIndex = 0;
        int n = nums.length;

        while (curIndex <= maxIndex && curIndex < n) {
            maxIndex = Math.max(maxIndex, curIndex + nums[curIndex]);
            curIndex++;
        }

        return maxIndex >= n-1;
    }
}
