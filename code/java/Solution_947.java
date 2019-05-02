
// union find
class Solution_947 {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for (int[] stone : stones) {
            uf.union(stone[0], ~stone[1]);
        }
        return stones.length - uf.getNumberOfComponent();
        
        
    }
}

class UnionFind {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> rank;
    int numberOfComponent;
    public UnionFind() {
        parent = new HashMap<>();
        rank = new HashMap<>();
        numberOfComponent = 0;
    }
    public int find(int p) {
        if (parent.putIfAbsent(p, p) == null) {
            numberOfComponent++;
            rank.put(p, 0);
        }
        if (p != parent.get(p)) {
            parent.put(p, find(parent.get(p)));
        }
        return parent.get(p);
    }
    
    public int getNumberOfComponent() {
        return numberOfComponent;
    }
    
    public void union(int p, int q) {
        p = find(p);
        q = find(q);
        if (p != q) {
            if (rank.get(p) < rank.get(q)) {
                parent.put(p, q);
            } else if (rank.get(p) > rank.get(q)) {
                 parent.put(q, p);
            } else {
                parent.put(q, p);
                rank.put(p, rank.get(p) + 1);
            }
           
            numberOfComponent--;
        }
    }
}

// dfs
class Solution_947 {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] stone : stones) {
            graph.computeIfAbsent(stone[0], k -> new ArrayList<>()).add(~stone[1]);
            graph.computeIfAbsent(~stone[1], k -> new ArrayList<>()).add(stone[0]);
        }
        int numOfComponent = 0;
        Set<Integer> visited = new HashSet<>();
        for (int[] stone : stones) {
            for (int i = 0; i < 2; i++) {
                int s = i == 0 ? stone[0] : ~stone[1];
                if (!visited.contains(s)) {
                    numOfComponent++;
                    dfs(s, graph, visited);
                }
            } 
        }
        return stones.length - numOfComponent;
    }
    
    private void dfs(int stone, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.add(stone)) {
            for (int next : graph.get(stone)) {
                dfs(next, graph, visited);
            }
        }
    }
}