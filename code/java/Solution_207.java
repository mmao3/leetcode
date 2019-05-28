//bfs
class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        int[] indgrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int [] prerequisite: prerequisites) {
            adjList[prerequisite[1]].add(prerequisite[0]);
            indgrees[prerequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indgrees[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int next : adjList[cur]) {
                indgrees[next]--;
                if (indgrees[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return count == numCourses;
    }
}

// dfs
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int [] prerequisite: prerequisites) {
            adjList[prerequisite[1]].add(prerequisite[0]);
        }
        int [] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(adjList, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(List<Integer>[] adjList, int [] visited, int i) {
        if (visited[i] == 2) {
            return false;
        }
        if (visited[i] == 1) {
            return true;
        }
        visited[i] = 1;
        for (int next : adjList[i]) {
            if (hasCycle(adjList, visited, next)) {
                return true;
            }
        }
        visited[i] = 2;
        return false;
    }
}