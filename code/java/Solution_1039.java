// dfs
class Solution_1039 {
    public int minScoreTriangulation(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[][] memo = new int[A.length][A.length];
        return minScoreTriangulation(A, 0, A.length - 1, memo);
        
    }
    public int minScoreTriangulation(int[] A, int i, int j, int[][] memo) {
        if (j <= i + 1) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k <= j - 1; k++) {
            min = Math.min(min, minScoreTriangulation(A, i, k, memo) + A[i] * A[k] * A[j] + minScoreTriangulation(A, k, j, memo));
        }
        memo[i][j] = min;
        return min;
    }
}

// dp
class Solution_1039 {
    public int minScoreTriangulation(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + A[i] * A[k] * A[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1]; 
    }
}