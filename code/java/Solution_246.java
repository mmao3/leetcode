class Solution_246 {
    public boolean isStrobogrammatic(String num) {
        String s = "69 96 11 00 88";
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!s.contains(num.charAt(i) + "" + num.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}