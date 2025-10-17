package Classic150.HashMap;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。

public class problem4 {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n != t.length()){
            return false;
        }

        int[] map = new int[26];
        for(int i=0; i<n; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            map[sc - 'a']++;
            map[tc - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(map[i] != 0){
                return false;
            }
        }
        return true;
    }
}
