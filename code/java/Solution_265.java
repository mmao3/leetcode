class Solution_265 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int preMin = 0;
        int preMinIndex = -1;
        int preSndMin = 0;
        int n = costs.length;
        int k = costs[0].length;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            int sndMin = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int val = costs[i][j] + (j == preMinIndex ? preSndMin : preMin);
                if (minIndex < 0 || val < min) {
                    sndMin = min;
                    min = val;
                    minIndex = j;
                } else if (val < sndMin) {
                    sndMin = val;
                }
            }
            preMinIndex = minIndex;
            preMin = min;
            preSndMin = sndMin;
        }
        return preMin;
    }
}