// dfs
class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            adjList[prerequisite[1]].add(prerequisite[0]);
        }
        int[] visited = new int[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(adjList, visited, i, stack)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res; 
    }
    
    private boolean hasCycle(List<Integer>[] adjList, int[] visited, int i, Deque<Integer> stack) {
        if (visited[i] == 2) {
            return false;
        }
        if (visited[i] == 1) {
            return true;
        }
        visited[i] = 1;
        for (int next : adjList[i]) {
            if (hasCycle(adjList, visited, next, stack)) {
                return true;
            }
        }
        stack.push(i);
        visited[i] = 2;
        return false;
    }
}

//bfs
class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adjList[prerequisite[1]].add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[index++] = cur;
            for (int next : adjList[cur]) {
                if (--indegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}