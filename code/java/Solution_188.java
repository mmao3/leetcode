class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        for (int i = 0; i < k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int i = k - 1; i >= 0; i--) {
                buy[i] = Math.max((i == 0 ? 0 : sell[i - 1]) - price, buy[i]);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k - 1];
        
    }
}