//memo + dfs
class Solution_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()]) {
            return res;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        return wordBreak(s, dict, map, 0);
    }
    
    private List<String> wordBreak(String s, Set<String> dict, Map<Integer, List<String>> map, int index) {
        if (index == s.length()) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        List<String> res = new ArrayList<>();
        for (int i = index + 1; i <= s.length(); i++) {
            String prefix = s.substring(index,  i);
            List<String> next = wordBreak(s, dict, map, i);
            if (dict.contains(prefix) && next.size() > 0) {
                for (String w : next) {
                    res.add(w.length() == 0 ? prefix : prefix + " " + w);
                }
            }
        }
        map.put(index, res);
        return res;
    }
}

//dp

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
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
        if (!dp[n]) {
            return  new ArrayList<>();
        }
        List<String>[] res = new List[n + 1];
        res[0] = new ArrayList<>(Arrays.asList(""));
        for (int i = 1; i <= n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                String prefix = s.substring(j, i);
                if (res[j].size() > 0 && dict.contains(prefix)) {
                    for (String w : res[j]) {
                        list.add(w.length() == 0 ? prefix : w + " " + prefix);
                    }
                }
            }
            res[i] = list; 
        }
        return res[n];
    }
}


