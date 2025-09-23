package Hot100.Hash;

import java.util.*;
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

public class problem2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // 将字符串排序，作为键
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // 将原始字符串添加到对应的列表中
            anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());
            anagramGroups.get(sortedStr).add(str);
        }

        // 返回结果列表
        return new ArrayList<>(anagramGroups.values());
    }
}
