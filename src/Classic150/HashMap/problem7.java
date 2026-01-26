package Classic150.HashMap;

// 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

import java.util.*;

public class problem7 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list;

            if(!map.containsKey(key)){
                list = new ArrayList<>();
                ans.add(list);
                map.put(key, list);
            } else {
                list = map.get(key);
            }
            list.add(s);
        }

        return ans;
    }
}
