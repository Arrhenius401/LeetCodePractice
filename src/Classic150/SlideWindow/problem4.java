package Classic150.SlideWindow;

//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
//
//测试用例保证答案唯一。

import java.util.HashMap;
import java.util.Map;

public class problem4 {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        int n = s.length();
        int left = 0, right = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }{

        }

        String ans = "";
        int ansLen = Integer.MAX_VALUE;
        while (right < n) {
            char c = s.charAt(right);
            map1.put(c, map1.getOrDefault(c, 0) + 1);

            if(isEnough(map1, map2)) {
                for (; left <= right; left++) {
                    char sc = s.charAt(left);
                    map1.put(sc, map1.get(sc) - 1);
                    if(!isEnough(map1, map2)) {
                        int curLen = right - left + 1;
                        if(ansLen > curLen) {
                            ans = s.substring(left, right+1);
                            ansLen = curLen;
                        }
                        left++;
                        break;
                    }
                }

            }

            right++;
        }

        return ans;
    }

    public boolean isEnough(Map<Character, Integer> map1, Map<Character, Integer> map2){
        for (Map.Entry<Character, Integer> entry: map2.entrySet()) {
            Character key = entry.getKey();
            if(!map1.containsKey(key) || map1.get(key) < entry.getValue()){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A";
        String t = "A";
        problem4 p = new problem4();

        System.out.println(p.minWindow(s, t));
    }
}
