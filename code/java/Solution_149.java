class Solution_149 {
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int max = 0;
            int dulplicate = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if (dx == 0 && dy == 0) {
                    dulplicate++;
                    continue;
                }
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String key = dx + " " + dy;
                map.put(key, map.getOrDefault(key, 0) + 1); 
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + 1 + dulplicate);
        }
        return res;
    }
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
