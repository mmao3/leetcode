class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> subBoard = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int startX = i / 3 * 3;
                int startY = i % 3 * 3;
                if (board[startX + j / 3][startY + j % 3] != '.' && !subBoard.add(board[startX + j / 3][startY + j % 3])) {
                    return false;
                }
            }
        }
        return true;
        
    }
}