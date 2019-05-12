class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
            } else {
                int j = i;
                while (j < s.length() && bold[j]) {
                    j++;
                }
                sb.append("<b>").append(s.substring(i, j)).append("</b>");
                i = j - 1;
            }
        }
        return sb.toString();
    }
}