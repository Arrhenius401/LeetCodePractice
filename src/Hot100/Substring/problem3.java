package Hot100.Substring;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class problem3 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        int tLen = t.length(), sLen = s.length();
        int len = Integer.MAX_VALUE;
        int start = 0, end = 0;
        //小心溢出
        int ansL = -1, ansR = -1;

        if(sLen < tLen){
            return "";
        }

        for(int i=0; i < tLen; i++){
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for(start = 0; start<sLen; start++){
            while (!check(tMap, sMap) && end < sLen){
                char c = s.charAt(end++);
                if(tMap.containsKey(c)){
                    sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                }
            }

            if (check(tMap, sMap) && (end - start) < len){
                len = end - start;
                ansL = start;
                ansR = end;
            }

            char sc = s.charAt(start);
            if(tMap.containsKey(sc)){
                sMap.put(sc, sMap.get(sc) - 1);
            }
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check(HashMap<Character, Integer> tMap, HashMap<Character, Integer> sMap){
        //entrySet()：是 Map 的一个方法，返回一个 Set<Map.Entry> 集合。这个集合中存储的元素就是 Map 中所有的键值对（每个元素都是一个 Map.Entry 对象）。
        //iterator()：是 Set 集合的方法，返回一个 迭代器（Iterator）。
        Iterator iter = tMap.entrySet().iterator();

        while (iter.hasNext()){
            //Map 是存储键值对（key-value）的集合，但 Map 本身并不是直接存储键值对的容器，而是通过内部的 Entry 接口来封装每一组键值对。
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if(sMap.getOrDefault(key, 0) < val){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "cba";
        problem3 p = new problem3();
        System.out.println(p.minWindow(s, t));
    }
}
