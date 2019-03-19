class Solution_904 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (count == K) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }
        return sb.reverse().toString();
    }
}



class Solution_904_1 {
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