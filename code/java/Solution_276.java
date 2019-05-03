class Solution_276 {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }
        int nextToLast = k;
        int last = k * k;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = (nextToLast + last) * (k - 1);
            nextToLast = last;
            last = cur;
        }
        return last;
        
    }
}