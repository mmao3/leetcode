class Solution_289 {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = 0;
                for (int[] dir : DIRS) {
                    int neighborX = i + dir[0];
                    int neighborY = j + dir[1];
                    if (neighborX < 0 || neighborX >= board.length || neighborY < 0 || neighborY >= board[0].length) {
                        continue;
                    }
                    if (board[neighborX][neighborY] == 1 || board[neighborX][neighborY] == 2) {
                        lives++;
                    }
                }
                if (board[i][j] == 1 && (lives < 2 || lives > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 3;
                }
            
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] &= 1;
            }
        }
    }
}