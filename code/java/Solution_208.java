class Trie {
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.containsKey(ch)) {
                cur.put(ch, new TrieNode());
            }
            cur = cur.get(ch);
        }
        cur.setEnd();
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.containsKey(ch)) {
                return false;
            }
            cur = cur.get(ch);
        }
        return cur.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (!cur.containsKey(ch)) {
                return false;
            }
            cur = cur.get(ch);
        }
        return true;
    }
}

class TrieNode {
    private boolean isEnd;
    private TrieNode[] links;
    private final int R = 26;
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
}