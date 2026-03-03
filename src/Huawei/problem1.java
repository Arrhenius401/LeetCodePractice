package Huawei;

//华为0409
//某测试工具升级时总选择迭代次数最多的补丁版本，已知这些补丁版本的前序版本(即依赖该版本修改发布新补丁版本)，前序版本的个数<=1，且不会存在互为前序版本的情况。请给出最终可以升级的补丁版本。版本号只包含大写字母和数字。

import java.io.*;
import java.util.*;

public class problem1 {

    private static Map<String, String> versionMap = new HashMap<>();
    private static Map<String, Integer> depthCache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // 1. 替换Scanner为BufferedReader，提升大数量输入效率
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 读取第一行：版本关系个数N
        int N = Integer.parseInt(br.readLine().trim()); // 去除首尾空格，避免格式问题

        Set<String> allVersions = new HashSet<>();

        // 读取后续N行：版本关系
        for (int i = 0; i < N; i++) {
            // 读取一行并去除首尾空格
            String line = br.readLine().trim();
            // 按空格分割（注意：版本字符串本身不含空格，split(" ")即可）
            String[] parts = line.split(" ");
            // 防御性处理：确保每行有且仅有两个字段
            if (parts.length != 2) {
                continue; // 非法行跳过（题目保证输入合法时可省略）
            }
            String currentVersion = parts[0];
            String preVersion = parts[1];

            // 存储版本映射关系
            versionMap.put(currentVersion, preVersion);
            // 收集所有版本（包括当前版本和前置版本）
            allVersions.add(currentVersion);
            if (!"NA".equals(preVersion)) {
                allVersions.add(preVersion);
            }
        }
        br.close(); // 关闭流

        // 2. 计算每个版本的迭代深度（逻辑和之前一致）
        int maxDepth = -1;
        Map<Integer, List<String>> depth2Versions = new HashMap<>();
        for (String version : allVersions) {
            int depth = calculateDepth(version);
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            depth2Versions.computeIfAbsent(depth, k -> new ArrayList<>()).add(version);
        }

        // 3. 输出处理
        outputResult(depth2Versions.get(maxDepth));
    }

    // 计算迭代深度（逻辑不变）
    private static int calculateDepth(String version) {
        if (depthCache.containsKey(version)) {
            return depthCache.get(version);
        }
        String preVersion = versionMap.getOrDefault(version, "NA");
        int depth = "NA".equals(preVersion) ? 0 : calculateDepth(preVersion) + 1;
        depthCache.put(version, depth);
        return depth;
    }

    // 二、输出处理：核心逻辑
    private static void outputResult(List<String> resultVersions) {
        // 1. 排序：按字典序（Java的String默认排序就是字典序）
        Collections.sort(resultVersions);

        // 2. 拼接为空格分隔的字符串并输出
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultVersions.size(); i++) {
            if (i > 0) {
                sb.append(" "); // 非第一个元素前加空格
            }
            sb.append(resultVersions.get(i));
        }
        System.out.println(sb.toString());

        // 简化写法（JDK8+）：
        // System.out.println(String.join(" ", resultVersions));
    }
}
