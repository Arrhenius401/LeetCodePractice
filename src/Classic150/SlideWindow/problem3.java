package Classic150.SlideWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class problem3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && left <= map.get(c)){
                left = map.get(c) + 1;
                map.put(c, i);
            }else {
                map.put(c, i);
                max = Math.max(max, i - left + 1);
            }
        }
        
        
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        problem3 p = new problem3();

        System.out.println(p.lengthOfLongestSubstring(s));
    }
}
