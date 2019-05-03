class Solution_256 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int r = 0;
        int b = 0;
        int g = 0;
        for (int i = 0; i < costs.length; i++) {
            int rr = r, bb = b, gg = g;
            r = costs[i][0] + Math.min(bb, gg);
            b = costs[i][1] + Math.min(rr, gg);
            g = costs[i][2] + Math.min(bb, rr);
        }
        return Math.min(r, Math.min(b, g));
        
    }
}