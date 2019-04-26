// solution 1 dfs
class Solution_200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

// solution 2 bfs
class Solution_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.offer(i * col + j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.poll();
                        int r = id / col;
                        int c = id % col;
                        if (r + 1 < row && grid[r + 1][c] == '1') {
                            neighbors.offer((r + 1) * col + c);
                            grid[r + 1][c] = '0';
                        }
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            neighbors.offer((r - 1) * col + c);
                            grid[r - 1][c] = '0';
                        }
                        if (c + 1 < col && grid[r][c + 1] == '1') {
                            neighbors.offer(r * col + c + 1);
                            grid[r][c + 1] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            neighbors.offer(r * col + c - 1);
                            grid[r][c - 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}

// union find 

class Solution_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int row = grid.length;
        int col = grid[0].length;
        for (int i  = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int p = i * col + j;
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        uf.union(p, p + col);
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        uf.union(p, p + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
class UnionFind {
    private int count;
    private int[] parent;
    private int[] rank;
    public UnionFind(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        parent = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    int p = i * col + j;
                    parent[p] = p;
                }
            }
        }
        rank = new int[row * col];
    }
    
    public int getCount() {
        return count;
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
