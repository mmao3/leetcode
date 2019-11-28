class Solution {
    public String rearrangeString(String s, int k) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.offer(new int[]{i, map[i]});
            }
        }
        StringBuilder res = new StringBuilder();
        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res.append((char)(cur[0] + 'a'));
            cur[1]--;
            q.offer(cur);
            if (q.size() >= k) {
                int[] front = q.poll();
                if (front[1] > 0) {
                    pq.offer(front);
                }
            }
        }
        return res.length() == s.length() ? res.toString() : "";
    }
}