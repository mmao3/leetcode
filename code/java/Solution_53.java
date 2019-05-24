class Solution_53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxSoFar = 0;
        for (int num : nums) {
            maxSoFar = maxSoFar < 0 ? num : maxSoFar + num;
            max = Integer.max(max, maxSoFar);
        }
        return max;
    }
}