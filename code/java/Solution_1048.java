class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;  
    }
    
    private boolean isPredecessor(String w1, String w2) {
        if (w1.length() == w2.length()) {
            return false;
        }
        for (int i = 0, j = 0; i < w1.length();) {
            if (w1.charAt(i) == w2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
                if (j - i > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}