class Solution_253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
        
    }
}