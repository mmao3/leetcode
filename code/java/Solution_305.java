class Solution_305 {
    int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m * n);
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            int p = position[0] * n + position[1];
            uf.addLand(p);
            for (int[] dir : DIRS) {
                int neighboarX = position[0] + dir[0];
                int neighboarY = position[1] + dir[1];
                int q = neighboarX * n + neighboarY;
                if (neighboarX >= 0 && neighboarX < m && neighboarY >= 0 && neighboarY < n && uf.isIsland(q)) {
                    uf.union(p, q);
                }
            }
            res.add(uf.getCount());
        }
       
        return res;
    }
}

class UnionFind {
    private int count;
    private int[] parent;
    private int[] rank;
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }
    
    public int getCount() {
        return count;
    }
    
    public void addLand(int p) {
        parent[p] = p;
        count += 1;
    }
    
    public boolean isIsland(int p) {
        return parent[p] != -1;
    }
    
    public int find(int p) {
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
        // int root = parent[p];
        // while (root != parent[root]) {
        //     root = parent[root];
        // }
        // while (p != root) {
        //     int next = parent[p];
        //     parent[p] = root;
        //     p = next;
        // }
        // return root;
        
    }
    
    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp != rootq) {
            if (rank[rootp] > rank[rootq]) {
                parent[rootq] = rootp;
            } else if (rank[rootp] < rank[rootq]) {
                parent[rootp] = rootq;
            } else {
                parent[rootp] = rootq;
                rank[rootq]++;
            }
            count--;
        }
    }
}
