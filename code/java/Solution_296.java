class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Collections.sort(cols);
        return minDistance(cols) + minDistance(rows);
    }
    
    private int minDistance(List<Integer> points) {
        int i = 0;
        int j = points.size() - 1;
        int distance = 0;
        while (i <= j) {
            distance += points.get(j) - points.get(i);
            j--;
            i++;
        }
        return distance;
    }
}