package Hot100.GraphTheory;

public class Trie {

//    Set<String> wordSet;
//    Set<String> prefixSet;
//
//    public Trie() {
//        wordSet = new HashSet<>();
//        prefixSet = new HashSet<>();
//    }
//
//    public void insert(String word) {
//        int n = word.length();
//
//        for(int i=0; i<n; i++){
//            String sub = word.substring(0,i+1);
//            if(!prefixSet.contains(sub)){
//                prefixSet.add(sub);
//            }
//        }
//
//        if(!wordSet.contains(word)){
//            wordSet.add(word);
//        }
//    }
//
//    public boolean search(String word) {
//        if(wordSet.contains(word)){
//            return true;
//        }
//        return false;
//    }
//
//    public boolean startsWith(String prefix) {
//        if(prefixSet.contains(prefix)){
//            return true;
//        }
//        return false;
//    }


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

}
