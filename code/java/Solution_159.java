class Solution_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        int maxLength = 0;
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < len; j++) {
            char c = s.charAt(j);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (count.size() > 2) {
                char cc = s.charAt(i);
                count.put(cc, count.get(cc) - 1);
                if (count.get(cc) == 0) {
                    count.remove(cc);
                }
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}