class Solution_322 {
    public int coinChange(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int m =  coinChange(coins, amount - coin, memo);
                if (m >= 0 && m < min) {
                    min = m + 1;
                }
            }
        }
        memo[amount - 1]  = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount - 1];
        
        
    }
    public int coinChange(int[] coins, int amount) {        
        return coinChange(coins, amount, new int[amount]);
    }
}

class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i - 1] && dp[j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}