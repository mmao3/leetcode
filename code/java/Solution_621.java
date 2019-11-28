class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int maxFreq = 0;
        int maxFreqCount = 0;
        for (char c : tasks) {
            counter[c - 'A']++;
            if (counter[c - 'A'] == maxFreq) {
                maxFreqCount++;
            } else if (counter[c - 'A'] > maxFreq) {
                maxFreq = counter[c - 'A'];
                maxFreqCount = 1;
            }
        }
        int res = (maxFreq - 1) * (n + 1) + maxFreqCount;
        return Math.max(res, tasks.length);
    }
}