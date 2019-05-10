// solution1 dp
class Solution_774 {
    public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;
        double[] delta = new double[n - 1];
        for (int i = 0; i < n - 1; i++) {
            delta[i] = stations[i + 1] - stations[i];
        }
        double[][] dp = new double[n - 1][K + 1];
        for (int i = 0; i <= K; i++) {
            dp[0][i] = delta[0] / (i + 1);
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= K; j++) {
                double min = Double.MAX_VALUE;
                for (int k = 0; k <= j; k++) {
                    min = Math.min(min, Math.max(dp[i - 1][j - k], 1.0 * delta[i] / (k + 1)));
                }
                dp[i][j] = min;
            }
        }
        return dp[n - 2][K];
    }
}

//solution2 priority queue
class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 1.0 * b[0] / a[0] < 1.0 * b[1] / a[1] ? -1 : 1);
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new int[]{stations[i + 1] - stations[i], 1});
        }
        for (int i = 0; i < K; i++) {
            int[] cur = pq.poll();
            cur[1]++;
            pq.offer(cur);
        }
        int[] node = pq.poll();
        return 1.0 * node[0] / node[1];
    }
}

//solution3 binary search
class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;
        double l = 0;
        double h = stations[n - 1] - stations[0];
        while (l + 1e-6 < h) {
            double mid = l + (h - l) / 2;
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                count += (int)((stations[i + 1] - stations[i]) / mid);
            }
            if (count > K) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return h;
    }
}