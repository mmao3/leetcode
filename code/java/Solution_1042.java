class Solution_1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        List<Integer>[] adjList = new List[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            adjList[path[0] - 1].add(path[1] - 1);
            adjList[path[1] - 1].add(path[0] - 1);
        }
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            for (int adj : adjList[i]) {
                used[ans[adj]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    ans[i] = j;
                }
            }
        }
        return ans;
    }
}

