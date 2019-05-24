// dfs
class Solution_200 {
    int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    numIslands(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    
    private void numIslands(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        for (int[] dir : DIRS) {
            numIslands(grid, i + dir[0], j + dir[1], visited);
        }
        
    }
}

// unionFind

class Solution_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) { 
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int p = i * n + j;
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        uf.union(p, p + n);
                    } 
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        uf.union(p, p + 1);
                    }
                }
            }
        }
        return uf.getCount();
        
    }
    
}

public class UnionFind {
    int[] parent;
    int[] rank;
    int count;
    
    public UnionFind(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                parent[i * n + j] = i * n + j;
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
    }
    
    public int find(int p) {
        if (p != parent[p]) {
            int root = find(parent[p]);
            parent[p] = root;
        }
        return parent[p];
    }
    
    public void union(int p, int q) {
        p = find(p);
        q = find(q);
        if (p != q) { 
            if (rank[p] < rank[q]) {
                parent[p] = q;
            } else if (rank[q] < rank[p]) {
                parent[q] = p;
            } else {
               parent[q] = p;
                rank[p]++;
            }
            count--;
        }
    }
    
    public int getCount() {
        return count;
    }
}

