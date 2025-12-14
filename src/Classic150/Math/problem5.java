package Classic150.Math;

// 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。

import java.util.*;

public class problem5 {
    public double myPow(double x, int n) {
        double ans = 1;
        boolean isPositive = n >= 0 ? true : false;
        String binaryStr = Integer.toBinaryString(Math.abs(n));

        // 指数构建列表
        double temp = x;
        for (int i = binaryStr.length()-1; i >= 0; i--) {
            ans *= binaryStr.charAt(i) == '1' ? temp : 1;
            temp *= temp;
        }

        return isPositive ? ans : 1/ans;
    }
}
