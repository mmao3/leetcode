class Solution_123 {
    public int maxProfit(int[] prices) {
        int[] buy = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] sell = new int[2];
        for (int price : prices) {
            buy[1] = Math.max(buy[1], sell[0] - price);
            sell[1] = Math.max(sell[1], buy[1] + price);
            buy[0] = Math.max(buy[0], -price);
            sell[0] = Math.max(sell[0], buy[0] + price);
            
        }
        return sell[1];
    }
}