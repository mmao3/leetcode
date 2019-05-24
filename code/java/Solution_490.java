class Solution {
    public static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        Queue<int[]> q = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
            for (int[] dir : DIRS) {
                int[] next = {cur[0], cur[1]};
                while (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && maze[next[0]][next[1]] == 0) {
                    next[0] += dir[0];
                    next[1] += dir[1];
                }
                next[0] -= dir[0];
                next[1] -= dir[1];
                if (visited[next[0]][next[1]]) {
                    continue;
                }
                visited[next[0]][next[1]] = true;
                q.offer(next);
            }
        }
        return false;
    }
}