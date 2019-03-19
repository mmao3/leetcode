class Solution_482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                sb.append(sb.length() % (K + 1) == K ? '-' : "").append(Character.toUpperCase(c));
            }
        }
        return sb.reverse().toString();
    }
}