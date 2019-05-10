class Solution_939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.computeIfAbsent(point[0], k -> new HashSet<>()).add(point[1]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] - points[i][0] == 0 || points[j][1] - points[i][1] == 0) {
                    continue;
                }
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    min = Math.min(Math.abs((points[j][0] - points[i][0]) * (points[j][1] - points[i][1])), min);
                }
                
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
        
    }
}