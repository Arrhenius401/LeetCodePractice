package Classic150.Array_SubString;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

public class problem21 {
    public int trap(int[] height) {
        int n = height.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = height[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i-1], height[i]);
        }

        dp2[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i+1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(dp1[i], dp2[i]) - height[i];
        }

        return ans;
    }
}
