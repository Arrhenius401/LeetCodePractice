package Classic150.BackTracking;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母

import java.util.ArrayList;
import java.util.List;

public class problem3 {
    List<String> ans;
    List<Character> path;
    char[][] map = {{}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'},
            {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'},
            {'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        path = new ArrayList<>();

        backtrack(digits, 0);

        return ans;
    }

    public void backtrack(String digits, int curIndex){
        if(curIndex >= digits.length()){
            StringBuilder builder = new StringBuilder();
            for (char c: path){
                builder.append(c);
            }
            ans.add(builder.toString());
            return;
        }

        int curChar = digits.charAt(curIndex) - '1';
        for (int i = 0; i < map[curChar].length; i++) {
            path.add(map[curChar][i]);
            backtrack(digits, curIndex+1);
            path.removeLast();
        }
    }
}
