class Solution_1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry e : map.entrySet()) {
            pq.offer(e);
        }
        int[] res = new int[barcodes.length];
        int index = 0;
        while (!pq.isEmpty()) {
            List<Map.Entry> list = new ArrayList<>();
            int k = 2;
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Integer, Integer> cur = pq.poll();
                map.put(cur.getKey(), map.get(cur.getKey()) - 1);
                list.add(cur);
                k--;
                res[index++] = cur.getKey();
            }
            for (Map.Entry<Integer, Integer> e : list) {
                if (e.getValue() > 0) {
                    pq.offer(e);
                }
            }
        }
        return res;
    }
}