package Classic150.HashMap;

//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
//如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
//每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

import java.util.HashMap;

public class problem2 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        if(n != t.length()){
            return false;
        }

        for(int j=0; j<2; j++){
            HashMap<Character, Character> map = new HashMap<>();
            String temp = s;
            s = t;
            t = temp;
            for(int i=0; i<n; i++){
                char sc = s.charAt(i);
                char tc = t.charAt(i);
                if(!map.containsKey(sc)){
                    map.put(sc, tc);
                } else if(map.get(sc) != tc) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "foo", t = "bar";
        problem2 p = new problem2();
        System.out.println(p.isIsomorphic(s, t));
    }
}
