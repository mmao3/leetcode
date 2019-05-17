class Solution_11 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
        
    }
}