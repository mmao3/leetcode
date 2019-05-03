class Solution_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int citation : citations) {
            count[Math.min(n, citation)]++;
        }
        int s = 0;
        for (int i = n; i >= 0; i--) {
            s += count[i];
            if (s >= i) {
                return i;
            }
        }
        return 0;
    }
        
}