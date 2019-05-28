class Solution_909 {
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        int step = 0;
        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n * n) {
                    return step;
                }
                for(int j = cur + 1; j <= Math.min(n * n, cur + 6); j++) {
                    int[] next = get(j, n);
                    int x = next[0];
                    int y = next[1];
                    int des = board[x][y] == -1 ? j : board[x][y];
                    if (!visited[des]) {
                        q.offer(des);
                        visited[des] = true;
                    }
                    
                }
                
            }
            step++;
        }
        return -1;
    }
    
    public int[] get(int s, int n) {
        int quot = (s - 1) / n;
        int rem = (s - 1) % n;
        int row = n - 1 - quot;
        int col = quot % 2 == 0 ? rem : n - 1 - rem;
        return new int[]{row, col};
        
    }
}