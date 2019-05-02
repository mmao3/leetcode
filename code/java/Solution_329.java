// solution 1, dfs with memorization 
class Solution_329 {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int res = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, matrix, cache));
            }
        }
        return res;
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        int max = 1;
        for (int[] dir : DIRS) {
            int nextX = dir[0] + i;
            int nextY = dir[1] + j;
            if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && matrix[i][j] > matrix[nextX][nextY]) {
               max = Math.max(max, 1 + dfs(nextX, nextY, matrix, cache));
            }
        }
        cache[i][j] = max;
        return max;
    }
}

// topological sort solution
class Solution_329 {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] grid = new int[m + 2][n + 2];
        for (int i = 0; i <= m + 1; i++) {
           for (int j = 0; j <= n + 1; j++) {
               if (i == 0 || i == m + 1 || j == 0 || j == n + 1) {
                   grid[i][j] = Integer.MAX_VALUE;
               } else {
                   grid[i][j] =  matrix[i - 1][j - 1];
               }
           }
        }
        int[][] indgrees = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int[] dir : DIRS) {
                    if (grid[i][j] > grid[i + dir[0]][j + dir[1]]) {
                        indgrees[i][j]++;
                    }
                }
            }
        }
        Queue<int[]> leaves = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (indgrees[i][j] == 0) {
                    leaves.add(new int[]{i, j});
                }
            }
        }
        
        int level = 0;
        while (!leaves.isEmpty()) {
            level++;
            int l = leaves.size();
            for (int i = 0; i < l; i++) {
                int[] leaf = leaves.poll();
                for (int[] dir : DIRS) {
                    int nextX = dir[0] + leaf[0];
                    int nextY = dir[1] + leaf[1];
                    if (grid[nextX][nextY] > grid[leaf[0]][leaf[1]]) {
                        if (--indgrees[nextX][nextY] == 0) {
                            leaves.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
        return level;
    }
}
