package Huawei;

import java.util.Scanner;

//0709
//古代仪式的准备
public class problem6 {
    public static int needPower = Integer.MAX_VALUE;
    public static int havePower = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }

        int roof = in.nextInt();
        int need = in.nextInt();
        int n = in.nextInt();

        int[][] power = new int[n][2];
        for (int i = 0; i < n; i++) {
            power[i][0] = in.nextInt();
            power[i][1] = in.nextInt();
        }

        dp(need, roof, power);

        if(needPower == Integer.MAX_VALUE) {
            System.out.println(0 + " " + 0);
            return;
        }
        System.out.println(needPower + " " + havePower);
    }

    //使用背包算法
    private static void dp(int need, int roof, int[][] power){
        int[] dp = new int[need+1];

        for (int i = 0; i < power.length; i++) {
            for (int j = need; j >= power[i][1]; j--) {
                dp[j] = Math.max(dp[j], dp[j-power[i][1]] + power[i][0]);
            }
        }

        for (int i = 0; i < need; i++) {
            if(dp[i] >= roof){
                needPower = i;
                havePower = dp[i];
                break;
            }
        }
    }

    // 使用回溯算法
    private static void backtrack(int curNeed, int curPower, int need, int roof, int[][] power, int curN){
        if(curPower > roof && curNeed <= need) {
            if(curNeed <= needPower) {
                needPower = curNeed;
                havePower = curPower;
            }

            return;
        }

        int n = power.length;
        if(curNeed >= need || curN >= n) {
            return;
        }

        for (int i = curN; i < n; i++) {
            if(curNeed + power[i][1] <= need){
                curNeed += power[i][1];
                curPower += power[i][0];

                backtrack(curNeed, curPower, need, roof, power, i+1);

                curNeed -= power[i][1];
                curPower -= power[i][0];
            }
        }
    }

}
