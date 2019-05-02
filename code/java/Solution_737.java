class Solution_737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Integer> index = new HashMap<>();
        UnionFind uf = new UnionFind(pairs.size() * 2);
        int counter = 0;
        for (List<String> pair : pairs) {
            for (String p : pair) {
                if (!index.containsKey(p)) {
                    index.put(p, counter++);
                }
            }
            uf.union(index.get(pair.get(0)), index.get(pair.get(1))); 
        }
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i], w2 = words2[i];
            if (w1.equals(w2)) {
                continue;
            }
            if (!index.containsKey(w1) || !index.containsKey(w2) || uf.find(index.get(w1)) != uf.find(index.get(w2))) {
                return false;
            }
        }
        return true;
        
    }
    
    
    
    private boolean dfs(String w1, String w2, Map<String, List<String>> graph, Set<String> visited) {
        if (w1.equals(w2)) {
            return true;
        }
        if (!graph.containsKey(w1)) {
            return false;
        }
        if (visited.add(w1)) {
            for (String next : graph.get(w1)) {
                if (dfs(next, w2, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    private boolean bfs(String w1, String w2, Map<String, List<String>> graph) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(w1);
        visited.add(w1);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(w2)) {
                return true;
            }
            if (!graph.containsKey(cur)) {
                continue;
            }
            for (String next : graph.get(cur)) {
                if (visited.add(next)) {
                    q.offer(next);
                }
            }
            
        }
        return false;
    }
    
    private boolean dfs(String w1, String w2, Map<String, List<String>> graph) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        stack.push(w1);
        visited.add(w1);
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (cur.equals(w2)) {
                return true;
            }
            if (!graph.containsKey(cur)) {
                continue;
            }
            for (String next : graph.get(cur)) {
                if (visited.add(next)) {
                    stack.push(next);
                }
            }
        }
        return false;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int p) {
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
    public void union(int p, int q) {
        int rp = find(p);
        int rq = find(q);
        if (rp != rq) {
            if (rank[rp] < rank[rq]) {
                parent[rp] = rq;
            } else if (rank[rp] > rank[rq]) {
                parent[rq] = rp;
            } else {
                parent[rq] = rp;
                rank[rp]++;
            }
        }
    }
}