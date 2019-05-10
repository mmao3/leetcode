class Solution_777 {
     public boolean canTransform(String start, String end) {
        int length = start.length();
        for (int i = 0, j = 0; i < length || j < length; i++, j++) {
            while (i < length && start.charAt(i) == 'X') {
                i++;
            }
            while (j < length && end.charAt(j) == 'X') {
                j++;
            }
           
            if (i == length && j == length) {
                return true;
            }
            if (i == length || j == length) {
                return false;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && j > i) {
                return false;
            }
            if (start.charAt(i) == 'R' && j < i) {
                return false;
            }
        }
         return true;
    }
}