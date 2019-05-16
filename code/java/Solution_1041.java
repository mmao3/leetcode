class Solution_1041 {
    public boolean isRobotBounded(String instructions) {
        int i = 0, j = 0, x = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (char c : instructions.toCharArray()) {
            if (c == 'R') {
                x = (x + 1) % 4;
            } else if (c == 'L') {
                x = (x + 3) % 4;
                
            } else {
                i += dir[x][0];
                j += dir[x][1];
            }
        }
        return i == 0 && j == 0 || x > 0;
    }
}