package Classic150.DictionaryTree;

public class Trie {


    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie ans = searchPrefixNode(word);
        return ans != null && ans.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie ans = searchPrefixNode(prefix);
        return ans != null;
    }

    public Trie searchPrefixNode(String word){
        Trie node = this;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
