package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

public class problem3 {
    HashMap<Character, Character[]> map;
    List<String> res;
    String output;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        map = new HashMap<>();
        output = "";
        int n = digits.length();

        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        if(n == 0){
            return new ArrayList<>();
        }
        backtrack(digits, 0);

        return res;
    }

    public void backtrack(String digits, int startIndex){
        if(startIndex == digits.length()){
            res.add(output);
            return;
        }

        char ptr = digits.charAt(startIndex);
        Character[] charArray = map.get(ptr);
        for(int i=0; i<charArray.length; i++){
            output += charArray[i].toString();
            backtrack(digits, startIndex+1);
            output = output.substring(0, output.length());
        }
    }
}
