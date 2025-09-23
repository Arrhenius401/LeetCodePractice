package Hot100.GreedAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
//
//注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
//
//返回一个表示每个字符串片段的长度的列表。

public class problem4 {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> maxMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            maxMap.put(s.charAt(i), i);
        }

        int end = maxMap.get(s.charAt(0));
        int start = 0;
        for(int i=0; i<s.length(); i++){
            int itEnd = maxMap.get((s.charAt(i)));
            if(itEnd > end){
                end = itEnd;
            }
            if(i == end){
                ans.add(end-start+1);
                end = i+1;
                start = i+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        problem4 p = new problem4();

        System.out.println(p.partitionLabels(s));
    }
}
