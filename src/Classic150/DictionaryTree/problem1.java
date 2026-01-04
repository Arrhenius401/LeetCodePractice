package Classic150.DictionaryTree;

//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
//
//单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用

import java.util.*;

public class problem1 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        Trie trie = new Trie();

        for (String word: words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, ans);
            }
        }

        return ans.stream().toList();
    }

    public void dfs(char[][] board, Trie cur, int x, int y, Set<String> ans) {
        if(!cur.children.containsKey(board[x][y])) {
            return;
        }

        char ch = board[x][y];
        cur = cur.children.get(ch);
        if(!cur.word.equals("")) {
            ans.add(cur.word);
        }

        board[x][y] = '#';
        for (int[] dir: dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if(xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length) {
                dfs(board, cur, xx, yy, ans);
            }
        }
        board[x][y] = ch;
    }

    public static class Trie {
        Map<Character, Trie> children;
        boolean isEnd;
        String word;

        public Trie () {
            this.children = new HashMap<>();
            this.isEnd = false;
            this.word = "";
        }

        public void insert (String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
            cur.word = word;
        }

        public boolean search (String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                if(!node.children.containsKey(word.charAt(i))) {
                    return false;
                }
                node = node.children.get(word.charAt(i));
            }
            return node.isEnd;
        }
    }
}
