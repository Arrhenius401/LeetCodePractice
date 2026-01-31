package Classic150.DynamicProgram;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class problem3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> set = new HashSet<>();

        for (String word: wordDict) {
            set.add(word);
        }

        dp[0] = true;
        for (int i = 1; i < n+1; i++) {
            if(dp[i-1]){
                for (String word: set){
                    int endIndex = i - 1 + word.length() - 1;
                    if(endIndex >= n){
                        continue;
                    }
                    String sub = s.substring(i - 1, endIndex + 1);
                    if(sub.equals(word)){
                        dp[endIndex + 1] = true;
                    }
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] list = {"leet","code"};
        List<String> wordDict = new ArrayList<>();

        for (String word: list){
            wordDict.add(word);
        }

        problem3 p = new problem3();

        System.out.println(p.wordBreak(s, wordDict));
    }
}
