// dfs
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, Boolean> memo = new HashMap<>();
        return wordBreak(s, dict, memo, 0);
    }
    
    public boolean wordBreak(String s, Set<String> dict, Map<Integer, Boolean> map, int index) {
        if (index == s.length()) {
            return true;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        boolean res = false;
        for (int i = index + 1; i <= s.length(); i++) {
            String prefix = s.substring(index, i);
            if (dict.contains(prefix) && wordBreak(s, dict, map, i)) {
                res = true;
                break;
            }
        }
        map.put(index, res);
        return res;
    }
}

//dp

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}