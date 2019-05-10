class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() - b.length() == 0 ? a.compareTo(b) : b.length() - a.length());
        for (String candidate : d) {
            if (candidate.length() > s.length()) {
                return "";
            }
            int i = 0, j = 0;
            while (i < s.length()) {
                if (s.charAt(i) == candidate.charAt(j)) {
                    j++;
                }
                 if (j == candidate.length()) {
                    return candidate;
                }
                i++;
            }
        }
        return "";
    }
}