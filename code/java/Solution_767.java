class Solution {
    public String reorganizeString(String s) {
        int[] map = new int[26];
        int n = s.length();
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
            if (map[c - 'a'] > (n + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.offer(new int[]{i, map[i]});
            }
        }
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            res.append((char)(first[0] + 'a'));
            res.append((char)(second[0] + 'a'));
            if (--first[1] > 0) {
                pq.offer(first);
            }
            if (--second[1] > 0) {
                pq.offer(second);
            }   
        }
        if (!pq.isEmpty()) {
            res.append((char)(pq.poll()[0] + 'a'));
        }
        return res.toString();
    }
}