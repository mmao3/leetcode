/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution_158 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    char[] buf4 = new char[4];
    int index4;
    int len4;
    
    public int read(char[] buf, int n) {
        int total = 0;
        while (index4 < len4 && total < n) {
            buf[total++] = buf4[index4++];
        }
        while (total < n) {
            len4 = read4(buf4);
            int left = n - total;
            index4 = Math.min(left,  len4);
            for (int i = 0; i < index4; i++) {
                buf[total++] = buf4[i];
            }
            if (len4 < 4) {
                return total;
            }
        }
        return total;
    }
}