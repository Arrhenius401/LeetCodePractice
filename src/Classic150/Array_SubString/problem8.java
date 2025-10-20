package Classic150.Array_SubString;

//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
//给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。

public class problem8 {
    // 暴力破解
    public int canCompleteCircuitViolent(int[] gas, int[] cost) {
        int n = gas.length;

        // 锁定终点
        for (int i = 0; i < n; i++) {
            if(gas[i] - cost[i] < 0){
                continue;
            }

            // 开始流转
            int store = 0;
            int j = 0;
            for (; j < n; j++) {
                int station = (i+j)%n;
                store = store + gas[station] - cost[station];
                if(store < 0){
                    break;
                }
            }

            if(j == n){
                return i;
            }

        }

        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 最小盈余
        int minBalance = 0;
        // 最小盈余所对应的加油站后继
        int minIndex = 0;
        // 现存盈余
        int balance = 0;

        for (int i = 0; i < gas.length; i++) {
            balance = balance + gas[i] - cost[i];
            if(balance < minBalance){
                minBalance = balance;
                minIndex = i+1;
            }
        }

        return balance >= 0 ? minIndex : -1;
    }
}
