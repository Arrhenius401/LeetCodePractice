package Classic150.BFS;

//字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
//
//每一对相邻的单词只差一个字母。
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
//sk == endWord
//给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。

import java.util.*;

public class problem3 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Map<String, Boolean> isVisit = new HashMap<>();

        for (String s: wordList) {
            set.add(s);
            isVisit.put(s, false);
        }

        if (!set.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int step = 2;
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        if(k != cur.charAt(j) - 'a') {
                            StringBuilder build = new StringBuilder(cur);
                            build.setCharAt(j, (char)('a' + k));

                            String next = build.toString();
                            if(set.contains(next) && !isVisit.get(next)) {
                                if(next.equals(endWord)) {
                                    return step;
                                }

                                queue.offer(next);
                                isVisit.put(next, true);
                            }
                        }
                    }
                }
            }
            step++;
        }

        return 0;
    }
}
