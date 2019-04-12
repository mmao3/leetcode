class Solution_393 {
    public boolean validUtf8(int[] data) {
        int cnt = 0;
        for (int sequence : data) {
            if (cnt == 0) {
                if (sequence >> 5 == 0b110) {
                    cnt = 1;
                } else if (sequence >> 4 == 0b1110) {
                    cnt = 2;
                } else if (sequence >> 3 == 0b11110) {
                    cnt = 3;
                } else if (sequence >> 7 == 1) {
                    return false;
                }
            } else {
                if (sequence >> 6 != 0b10) {
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }
}