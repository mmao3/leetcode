class Solution_418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join(" ", sentence) + " ";
        int n = str.length();
        int len = 0;
        for (int i = 0; i < rows; i++) {
            len += cols;
            if (str.charAt(len % n) == ' ') {
                len++;
            } else {
                while (len > 0 && str.charAt((len  - 1 )% n) != ' ') {
                    len--;
                }
            }
        }
        return len / n;
    }
}
class Solution_418_1 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join(" ", sentence) + " ";
        int n = str.length();
        int[] positions = new int[n];
        for (int i = 1; i < n; i++) {
            positions[i] = str.charAt(i) == ' ' ? 1 : positions[i - 1] - 1;
        }
        int len = 0;
        for (int i = 0; i < rows; i++) {
            len += cols;
            len += positions[len % n];
        }
        return len / n;
    }
}