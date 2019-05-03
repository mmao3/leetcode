class Solution_248 {
    public static final char[][] PAIRS = new char[][]{{'0', '0'}, {'8', '8'}, {'1', '1'}, {'6', '9'}, {'9', '6'}};
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        for (int i = low.length(); i <= high.length(); i++) {
            count += dfs(low, high, new char[i], 0, i - 1);
        }
        return count;
    }
    
    private int dfs(String low, String high, char[] ch, int left, int right) {
        if (left > right) {
            String s = new String(ch);
            if (ch.length == low.length() && s.compareTo(low) < 0 ||
               ch.length == high.length() && s.compareTo(high) > 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int count = 0;
        for (char[] pair : PAIRS) {
            ch[left] = pair[0];
            ch[right] = pair[1];
            if (ch.length != 1 && ch[0] == '0') {
                continue;
            }
            if (left == right && pair[0] != pair[1]) {
                continue;
            }
            
            count += dfs(low, high, ch, left + 1, right - 1);
        }
        return count;
    }
}