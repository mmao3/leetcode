class Solution {
    int N = 20000;
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(b[0] + " " + b[1]);
        }
        return isEscapePossible(blockedSet, source, target) && isEscapePossible(blockedSet, target, source);
        
    }
    
    private boolean isEscapePossible(Set<String> blocked, int[] source, int[] target) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(source);
        visited.add(source[0] + " " + source[1]);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == target[0] && cur[1] == target[1] || visited.size() >= N) {
                return true;
            }
            for (int[] dir : DIRS) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                String key = nextX + " " + nextY;
                if (nextX < 0 || nextX >= 1e6 || nextY < 0 || nextY >= 1e6 || blocked.contains(key) || visited.contains(key)) {
                    continue;
                }
                q.offer(new int[]{nextX, nextY});
                visited.add(key);
            }
            
        }
        return false;
        
    }
}