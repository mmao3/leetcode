class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i] = new double[]{1.0 * wage[i] / quality[i], (double)quality[i]};
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> pq = new PriorityQueue<>();
        double minCost = Double.MAX_VALUE;
        double qualitySum = 0;
        for (double[] worker : workers) {
            qualitySum += worker[1];
            pq.offer(-worker[1]);
            if (pq.size() > K) {
                qualitySum += pq.poll();
            }
            if (pq.size() == K) {
                minCost = Math.min(minCost, worker[0] * qualitySum);
            }
        }
        return minCost;
    }
}