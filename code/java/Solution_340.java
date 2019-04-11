class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        Map<Character, Integer> count = new HashMap<>();
        int maxLength = 0;
        for (int i = 0, j = 0; j < len; j++) {
            char c = s.charAt(j);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (count.size() > k) {
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