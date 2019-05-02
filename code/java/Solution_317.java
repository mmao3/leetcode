class Solution_317 {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];
        int[][] reached = new int[rows][cols];
        int numOfBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    numOfBuildings++;
                    shortestDistance(i, j, distance, reached, grid, numOfBuildings);
                    
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && reached[i][j] == numOfBuildings) {
                    minDistance = Math.min(minDistance, distance[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;  
    }
    
    private void shortestDistance(int i, int j, int[][] distance, int[][] reached, int[][] grid, int numOfBuildings) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                for (int[] dir : DIRS) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || grid[nextX][nextY] != 0) {
                        continue;
                    }
                    if (visited[nextX][nextY]) {
                        // this empty land cannot be reached by every building, no need to go futher from this point 
                        if (reached[nextX][nextY] < numOfBuildings) {
                            break;
                        }
                        continue;
                    }
                    reached[nextX][nextY]++;
                    distance[nextX][nextY] += level;
                    q.offer(new int[]{nextX, nextY}); 
                    visited[nextX][nextY] = true;
                }  
            }
            ++level;
        }
        
    }
}