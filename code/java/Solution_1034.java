class Solution_1034 {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int oldColor = grid[r0][c0];
        if (color == oldColor) {
            return grid;
        }
        Queue<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.offer(r0*n + c0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curX = cur / n;
            int curY = cur % n;
            visited[curX][curY] = true;
            if (curX == 0  || curY == 0 || curX == m - 1 || curY == n - 1) {
                grid[curX][curY] = color;
            }
            for (int[] dir : DIRS) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                if (nextX < 0 || nextX == m || nextY < 0 || nextY == n || visited[nextX][nextY]) {
                    continue;
                }
                if (grid[nextX][nextY] != oldColor) {
                    grid[curX][curY] = color;
                } else {
                    queue.offer(nextX * n + nextY);
                }
                
            }
            
        }
        return grid;
    }
}