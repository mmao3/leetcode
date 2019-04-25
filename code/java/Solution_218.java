class Solution_218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for (int[] building : buildings) {
            height.add(new int[]{building[0], -building[2]});
            height.add(new int[]{building[1], building[2]});
        }
        Collections.sort(height, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int preMax = 0;
        for (int[] building : height) {
            if (building[1] < 0) {
                map.compute(-building[1], (k, v) -> v == null ? 1 : v + 1);
            } else {
               if (map.get(building[1]) > 1) {
                  map.compute(building[1], (k, v) -> v - 1); 
               } else {
                   map.remove(building[1]);
               }
            }
            int curMax = map.lastKey();
            if (curMax != preMax) {
                res.add(new int[] {building[0], curMax});
                preMax = curMax;
            }
            
           
        }
        return res;
    }
}