package Classic150.HashMap;

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
//如果可以，返回 true ；否则返回 false 。
//
//magazine 中的每个字符只能在 ransomNote 中使用一次。

import java.util.HashMap;
import java.util.HashSet;

public class problem1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if(map.containsKey(ransomNote.charAt(i))){
                int count = map.get(ransomNote.charAt(i)) - 1;

                if(count < 0){
                    return false;
                }

                map.put(ransomNote.charAt(i), count);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        problem1 p = new problem1();

        p.canConstruct(ransomNote, magazine);
    }
}
