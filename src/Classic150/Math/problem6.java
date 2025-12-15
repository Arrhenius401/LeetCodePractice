package Classic150.Math;

import java.util.HashMap;
import java.util.Map;

public class problem6 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans >= n-i || ans > n/2){
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }

                // 斜率编码：将(x,y)映射为唯一整数（避免浮点数精度问题）
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                int num = entry.getValue();
                // num是该斜率下的点数量（不含基准点i），+1是加上基准点本身
                maxn = Math.max(maxn, num+1);
            }
            ans = Math.max(ans, maxn);
        }

        return ans;
    }

    // 计算x和y的最大公约数（gcd）m
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
