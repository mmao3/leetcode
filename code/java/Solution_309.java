class Solution_309 {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int rest = 0;
        for (int price : prices) {
            int tem = sell;
            buy = Math.max(rest - price, buy);
            sell = Math.max(buy + price, sell);
            rest = Math.max(tem, rest);
        }
        return sell;
    }
}