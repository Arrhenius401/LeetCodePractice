package Classic150.Array_SubString;

//给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
//
//每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
//
//0 <= j <= nums[i] 且
//i + j < n
//返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。

public class problem19 {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int step = 0;
        int maxP = 0;

        for (int i = 0; i < n; i++) {
            maxP = Math.max(maxP, i + nums[i]);
            if(i == end){
                end = maxP;
                step++;
            }
        }

        return step;
    }

}
