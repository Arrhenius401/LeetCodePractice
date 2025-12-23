package Classic150.Array_SubString;

//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
//
//你需要按照以下要求，给这些孩子分发糖果：
//
//每个孩子至少分配到 1 个糖果。
//相邻两个孩子中，评分更高的那个会获得更多的糖果。
//请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。

public class problem16 {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] dpLeft = new int[n];
        dpLeft[0] = 1;
        for (int i = 1; i < n; i++) {
            dpLeft[i] = ratings[i] > ratings[i-1] ? dpLeft[i-1]+1 : 1;
        }

        int[] dpRight = new int[n];
        dpRight[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            dpRight[i] = ratings[i] > ratings[i+1] ? dpRight[i+1]+1 : 1;
        }

        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = Math.max(dpLeft[i], dpRight[i]);
            sum += ans[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        problem16 p = new problem16();
        int[] rating = {};

        System.out.println(p.candy(rating));
    }
}
