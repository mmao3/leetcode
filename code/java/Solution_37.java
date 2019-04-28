class Solution_37 {
    static final int D = 3;
    static final int N = D * D;
    public void solveSudoku(char[][] board) {
        solveSudoku(0, 0, board);
        
    }
    
    private boolean solveSudoku(int i, int j, char[][] board) {
        if (i == N) {
            return true;
        }
        if (j == N) {
            return solveSudoku(i + 1, 0,  board);
        }
        if (board[i][j] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, i, j, c)) {
                    board[i][j] = c;
                    if (solveSudoku(i, j + 1, board)) {
                        return true;
                    }
                    board[i][j] = '.';
                    
                }
            }
        } else {
            return solveSudoku(i, j + 1, board);
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        int startRow = row / D * D;
        int startCol = col / D * D;
        for (int i = 0; i < N; i++) {
            if (board[i][col] == c || board[row][i] == c || board[startRow + i / 3][startCol + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}