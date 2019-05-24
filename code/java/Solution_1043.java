class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[]dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] + A[j - 1];
            int max = A[j - 1];
            for (int i = j - 1; i >= Math.max(1, j - K + 1); i--) {
                max = Math.max(max, A[i - 1]);
                dp[j] = Math.max(dp[j], dp[i - 1] + max * (j - i + 1));
            }
        }
        return dp[n];
    }
}