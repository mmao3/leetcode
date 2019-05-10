class Solution_1040 {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int high = Math.max(stones[n - 2] - stones[0] - n + 2, stones[n - 1] - stones[1] - n + 2);
        int low = n;
        int i = 0;
        for (int j = 0; j < n; j++) {
            while (stones[j] - stones[i] >= n) {
                i++;
            }
            if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) {
                low = Math.min(low, 2);
            } else {
                low = Math.min(low, n - (j - i + 1));
            }
        }
        return new int[]{low, high};
        
    }
}