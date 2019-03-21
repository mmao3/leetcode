class Solution_686 {
    public int repeatedStringMatch(String A, String B) {
        int n = (int)Math.ceil(B.length() * 1.0 / A.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(A);
        }
        return sb.indexOf(B) >= 0 ? n : (sb.append(A).indexOf(B) > 0 ? n + 1 : -1);
    }
}