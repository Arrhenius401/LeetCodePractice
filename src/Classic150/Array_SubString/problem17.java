package Classic150.Array_SubString;

//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
//
//你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
//
//要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
//
//文本的最后一行应为左对齐，且单词之间不插入额外的空格。
//
//注意:
//
//单词是指由非空格字符组成的字符序列。
//每个单词的长度大于 0，小于等于 maxWidth。
//输入单词数组 words 至少包含一个单词。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem17 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        StringBuilder build = new StringBuilder();
        int wordSum = 0;

        for (int i = 0; i < words.length; i++) {
            wordSum += wordSum == 0 ? words[i].length() : 1 + words[i].length();
            map.put(ans.size(), map.getOrDefault(ans.size(), 0) + 1);

            if(i == words.length-1 || (wordSum + 1 + words[i+1].length() > maxWidth)) {
                int diff = maxWidth - wordSum;
                int eleNum = map.get(ans.size());
                int blankNum = i == words.length-1 ? diff : (eleNum == 1 ? diff : diff / (eleNum-1));

                for (int j = 0; j < eleNum; j++) {
                    build.append(j == 0 ? words[i-eleNum+j+1] : " " + words[i-eleNum+j+1]);

                    if(i != words.length-1) {
                        for (int k = 0; k < blankNum && (eleNum == 1 || j != eleNum-1); k++) {
                            build.append(" ");
                        }

                        if(eleNum != 1 && diff % (eleNum-1) > j) {
                            build.append(" ");
                        }
                    } else if(i == words.length-1 && j == eleNum - 1) {
                        for (int k = 0; k < blankNum; k++) {
                            build.append(" ");
                        }
                    }
                }
                ans.add(build.toString());

                build = new StringBuilder();
                wordSum = 0;
            }
        }

        return ans;
    }
}
