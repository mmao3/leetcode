class AutocompleteSystem {
    String prefix;
    Trie trie;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            trie.insert(prefix, 1);
            prefix = "";
            return res;
        }
        
        prefix += c;
        TrieNode node = trie.search(prefix);
        if (node == null) {
            return res;
        }
        List<Pair> list = trie.lookup(node, prefix);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count == 0 ? a.s.compareTo(b.s) : b.count - a.count);
        for (Pair p : list) {
            pq.offer(p);
        }
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().s);
        }
        return res;
        
    }
}

class Pair {
    String s;
    int count;
    public Pair(String s, int count) {
        this.s = s;
        this.count = count;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s, int count) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (!cur.containsKey(c)) {
                cur.set(c, new TrieNode());
            }
            cur = cur.get(c);
        }
        cur.isEnd = true;
        cur.count += count;
    }
    
    public TrieNode search(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.containsKey(c)) {
                return null;
            }
             
            cur = cur.get(c);
        }
        return cur;
    }
    
    public List<Pair> lookup(TrieNode node, String prefix) {
        List<Pair> res = new ArrayList<>();
        if (node.isEnd) {
            res.add(new Pair(prefix, node.count));
        }
        for (int i = 0; i < 27; i++) {
            if (node.containsKey(i)) {
                res.addAll(lookup(node.get(i), prefix + node.getChar(i)));
            }
        }
        return res;
        
    }
}



class TrieNode {
    boolean isEnd;
    int count;
    TrieNode[] links;
    
    public TrieNode() {
        links = new TrieNode[27];
    }
    
    public TrieNode get(int index) {
        return links[index];
    }
    
    public TrieNode get(char ch) {
        return links[getIndex(ch)];
    }
    
    public int getIndex(char ch) {
        return ch == ' ' ? 26 : ch - 'a';
    }
    
    public char getChar(int index) {
        return index == 26 ? ' ' : (char)('a' + index);
    }
    
    public void set(char ch, TrieNode node) {
        links[getIndex(ch)] = node;
    }
    
    public boolean containsKey(char ch) {
        return links[getIndex(ch)] != null;
    }
    
    public boolean containsKey(int index) {
        return links[index] != null;
    }
    
}