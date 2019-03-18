class Solution {
    public String nextClosestTime(String time) {
        if (time == null) {
            return "";
        }
        int[] digits = getDigits(time);
        int length = digits.length;
        int[] sorted = Arrays.copyOf(digits, length);
        Arrays.sort(sorted);
        for (int i = length - 1; i >= 0; i--) {
            int next = getHigher(sorted, digits[i]);
            if (next > digits[i]) {
                digits[i] = next;
                if (isValid(digits)) {
                    break;
                }
            }
            digits[i] = sorted[0];
        }
        return String.format("%02d:%02d", digits[0] * 10 + digits[1], digits[2] * 10 + digits[3]);
    }
    
    private int[] getDigits(String time) {
        int[] digits = new int[4];
        int index = 0;
        for (char c : time.toCharArray()) {
            if (c != ':') {
                digits[index++] = c - '0';
            }
        }
        return digits;
    }
    
    private int getHigher(int[] sorted, int val) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < sorted.length ? sorted[left] : sorted[0];
    }
    
    private boolean isValid(int[] digits) {
        return digits[0] * 10 + digits[1] < 24 && digits[2] * 10 + digits[2] < 60;
    }
}