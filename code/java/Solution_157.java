/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution_157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int total = 0;
        while (total < n) {
            int len = read4(buf4);
            int left = n - total;
            len = Math.min(len, left);
            for (int i = 0; i < len; i++) {
                buf[total++] = buf4[i];
            }
            if (len < 4) {
                return total;
            }
        }
        return total;
        
    }
}