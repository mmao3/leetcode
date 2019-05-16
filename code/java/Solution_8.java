class Solution_8 {
    public int myAtoi(String str) {
        int n = str.length();
        int res = 0;
        int index = 0;
        int sign = 1;
        while (index < n && str.charAt(index) == ' ') {
            index++;
        }
        if (index < n && ((str.charAt(index) == '+') || (str.charAt(index) == '-'))) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        while (index < n) {
            char c = str.charAt(index);
            if (!Character.isDigit(c)) {
                return res * sign;
            }
            int val = Character.getNumericValue(str.charAt(index));
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && val >= 8)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + val;
            index++;
        }
        
        return res * sign;
        
        
    }
}