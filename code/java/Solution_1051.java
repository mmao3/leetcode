class Solution_1051 {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] copy =  Arrays.copyOf(heights, n); 
        Arrays.sort(copy);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != copy[i]) {
                res++;
            }
        }
        return res;
    }
}