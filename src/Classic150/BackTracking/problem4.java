package Classic150.BackTracking;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class problem4 {
    List<String> path;
    StringBuilder builder;
    Set<String> set;

    public List<String> generateParenthesis(int n) {
        path = new ArrayList<>();
        builder = new StringBuilder();
        set = new HashSet<>();

        backtrack(n, 0);

        return path;
    }

    public void backtrack(int n, int curNum){
        if(curNum == n) {
            path.add(builder.toString());
            return;
        }

        int curLen = builder.length();
        for (int i = 0; i <= curLen; i++) {
            builder.insert(i, "()");
            if(!set.contains(builder.toString())){
                set.add(builder.toString());
                backtrack(n, curNum+1);
            }
            builder.delete(i, i+2);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        problem4 p = new problem4();

        List<String> ans = p.generateParenthesis(n);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
