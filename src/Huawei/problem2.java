package Huawei;

// 华为0409
// 大湾区某城市地铁线路非常密集，乘客很难一眼看出选择哪条线路乘坐比较合适，为了解决这个问题，地铁公司希望你开发一个程序帮助乘客挑选合适的乘坐线路，使得乘坐时间最短，地铁公司可以提供的数据是各相邻站点之间的乘坐时间。

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem2 {
    // 存储邻接表：key=站点，value=该站点的邻接站点及耗时（Map<邻接站点, 耗时>）
    private static Map<Character, Map<Character, Integer>> graph = new HashMap<>();
    // 存储最短距离：key=站点，value=起点到该站点的最短耗时
    private static Map<Character, Integer> dist = new HashMap<>();
    // 存储前驱节点：key=站点，value=该站点在最短路径上的前驱站点
    private static Map<Character, Character> prev = new HashMap<>();
    // 已访问的站点集合
    private static Set<Character> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 读取输入
        // 第一行：站点总数（本题中N仅用于范围约束，实际无需使用）
        int N = Integer.parseInt(scanner.nextLine().trim());
        // 第二行：出发站和到达站
        String[] startEnd = scanner.nextLine().trim().split(" ");
        char start = startEnd[0].charAt(0);
        char end = startEnd[1].charAt(0);

        // 第三行起：读取相邻站点耗时，直到"0000"结束
        while (true) {
            String line = scanner.nextLine().trim();
            if ("0000".equals(line)) {
                break;
            }
            String[] parts = line.split(" ");
            char a = parts[0].charAt(0);
            char b = parts[1].charAt(0);
            int time = Integer.parseInt(parts[2]);

            // 构建无向图的邻接表
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, time);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, time);
        }

        // 2. 初始化Dijkstra算法
        initDijkstra(start);

        // 3. 执行Dijkstra算法
        dijkstra(start);

        // 4. 回溯获取最短路径
        List<Character> path = getShortestPath(start, end);

        // 5. 输出路径（空格分隔）
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(path.get(i));
        }
        System.out.println(sb.toString());

        scanner.close();
    }

    /**
     * 初始化Dijkstra算法的距离和前驱节点
     */
    private static void initDijkstra(char start) {
        // 初始化所有站点的距离为无穷大，前驱为null
        for (char node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
            prev.put(node, null);
        }
        // 起点到自身的距离为0
        dist.put(start, 0);
    }

    /**
     * 核心：Dijkstra算法实现
     */
    private static void dijkstra(char start) {
        // 循环直到所有站点都被访问
        while (visited.size() < graph.size()) {
            // 步骤1：找到当前未访问的、距离起点最近的节点（u）
            char u = findMinDistanceNode();
            if (u == ' ') { // 无可达节点（题目保证有解，此情况不会出现）
                break;
            }
            visited.add(u);

            // 步骤2：松弛操作：更新u的邻接节点的距离
            Map<Character, Integer> neighbors = graph.get(u);
            for (Map.Entry<Character, Integer> entry : neighbors.entrySet()) {
                char v = entry.getKey();
                int time = entry.getValue();
                // 仅处理未访问的节点
                if (!visited.contains(v)) {
                    int newDist = dist.get(u) + time;
                    // 如果新距离更短，更新距离和前驱
                    if (newDist < dist.get(v)) {
                        dist.put(v, newDist);
                        prev.put(v, u);
                    }
                }
            }
        }
    }

    /**
     * 找到当前未访问的、距离起点最近的节点
     */
    private static char findMinDistanceNode() {
        char minNode = ' ';
        int minDist = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : dist.entrySet()) {
            char node = entry.getKey();
            int distance = entry.getValue();
            if (!visited.contains(node) && distance < minDist) {
                minDist = distance;
                minNode = node;
            }
        }
        return minNode;
    }

    /**
     * 从终点回溯前驱节点，得到最短路径（反转后为正序）
     */
    private static List<Character> getShortestPath(char start, char end) {
        List<Character> path = new ArrayList<>();
        // 从终点开始回溯
        char current = end;
        while (current != start) {
            path.add(current);
            current = prev.get(current);
        }
        // 添加起点
        path.add(start);
        // 反转得到正序路径
        Collections.reverse(path);
        return path;
    }
}
