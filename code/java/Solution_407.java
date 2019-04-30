class Solution_407 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]);
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i});
            visited[0][i] = true;
            pq.offer(new int[]{m - 1, i});
            visited[m - 1][i] = true;
        }
        for (int i = 1; i < m - 1; i++) {
            pq.offer(new int[]{i, 0});
            visited[i][0] = true;
            pq.offer(new int[]{i, n - 1});
            visited[i][n - 1] = true;
        }
        int total = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    int diff = heightMap[cur[0]][cur[1]] - heightMap[nextX][nextY];
                    total += Math.max(0, diff);
                    pq.offer(new int[]{nextX, nextY});
                    heightMap[nextX][nextY] = diff > 0 ? heightMap[cur[0]][cur[1]] : heightMap[nextX][nextY];
                    visited[nextX][nextY] = true;
                }
            }
            
        }
        return total;
        
    }
}