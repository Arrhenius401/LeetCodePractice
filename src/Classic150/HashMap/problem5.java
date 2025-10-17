package Classic150.HashMap;

//编写一个算法来判断一个数 n 是不是快乐数。
//
//「快乐数」 定义为：
//
//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果这个过程 结果为 1，那么这个数就是快乐数。
//如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

import java.util.HashMap;
import java.util.Map;

public class problem5 {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> slow;
        HashMap<Integer, Integer> fast;
        int slowNum = n, fastNum = n;

        while (fastNum != 1){
            slow = new HashMap<>();
            fast = new HashMap<>();
            // 填充map
            while (fastNum > 0){
                int ptr = fastNum%10;
                fastNum = fastNum/10;
                fast.put(ptr, fast.getOrDefault(ptr, 0)+1);
            }

            while (slowNum > 0){
                int ptr = slowNum%10;
                slowNum = slowNum/10;
                slow.put(ptr, slow.getOrDefault(ptr, 0)+1);
            }

            // 计算下一轮数字
            for(Integer key: fast.keySet()){
                fastNum += key*key*fast.get(key);
            }

            for(Integer key: slow.keySet()){
                slowNum += key*key*slow.get(key);
            }

            // fast轮回多一轮
            fast = new HashMap<>();
            while (fastNum > 0){
                int ptr = fastNum%10;
                fastNum = fastNum/10;
                fast.put(ptr, fast.getOrDefault(ptr, 0)+1);
            }

            // 循环判断
            for(Integer key: fast.keySet()){
                fastNum += key*key*fast.get(key);
            }

            // 快乐数判断
            if(fast.equals(slow)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 19;
        problem5 p = new problem5();
        System.out.println(p.isHappy(n));
    }
}
