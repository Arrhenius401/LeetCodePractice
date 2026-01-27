package Classic150.DoublePointers;

//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。
//
//说明：你不能倾斜容器。

public class problem4 {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        int ptr1 = 0, ptr2 = n-1;

        while (ptr1 < ptr2) {
            int sum = (ptr2 - ptr1) * Math.min(height[ptr1], height[ptr2]);
            ans = Math.max(ans, sum);

            if(height[ptr1] < height[ptr2]) {
                ptr1++;
            } else {
                ptr2--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        problem4 p = new problem4();
        int[] height = {1,2,4,3};

        System.out.println(p.maxArea(height));
    }
}
