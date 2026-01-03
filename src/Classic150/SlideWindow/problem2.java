package Classic150.SlideWindow;

//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
//
// s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
//
//例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
//返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int m = words.length, n = words[0].length(), sLen = s.length();

        // 遍历字符串初始位置
        for (int i = 0; i < n; i++) {
            if (i + m * n > sLen) {
                break;
            }

            Map<String, Integer> differ = new HashMap<>();
            // 在 differ 存储原字符串初始位置后的 m 个单词
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            // 遍历原 words 数组，在 differ 中进行删除
            for (String word: words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }

            // 滑动窗口
            for (int start = i; start < sLen - m * n +1; start += n) {
                if (start != i) {
                    // 此时的 word 是右侧新加入的单词
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    // 此时的 word 是左侧将离开的单词
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    ans.add(start);
                }
            }

        }

        return ans;
    }
}
