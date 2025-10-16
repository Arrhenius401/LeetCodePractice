package Classic150.HashMap;

//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
//这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。具体来说：
//
//pattern 中的每个字母都 恰好 映射到 s 中的一个唯一单词。
//s 中的每个唯一单词都 恰好 映射到 pattern 中的一个字母。
//没有两个字母映射到同一个单词，也没有两个单词映射到同一个字母。

import java.util.HashMap;

public class problem3 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(words.length != pattern.length()){
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if(!map1.containsKey(c) && !map2.containsKey(word)){
                map1.put(c, word);
                map2.put(word, c);
            } else if ((map1.containsKey(c) && !map1.get(c).equals(word)) || map2.get(word) != c) {
                return false;
            }
        }

        return true;
    }
}
