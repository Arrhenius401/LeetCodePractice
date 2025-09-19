package BackTracking;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class problem5 {

    List<String> res;
    StringBuilder output;

    public List<String> generateParenthesis(int n) {
        output = new StringBuilder();
        res = new ArrayList<>();

        if(n == 0) return res;
        backtrack(n, 0);
        return res;
    }

    public void backtrack(int n, int first){
        if(output.length() == n*2){
            res.add(new StringBuilder(output).toString());
            return;
        }

        for(int i=first; i<= output.length(); i++){
           output.insert(i, "()");
           backtrack(n, i+1);
           output.delete(i, i+2);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        problem5 p = new problem5();

        System.out.println(p.generateParenthesis(n));
    }
}
