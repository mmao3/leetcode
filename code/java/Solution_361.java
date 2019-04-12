class Solution_361 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        int killedEnemiesInRow = 0;
        int[] killedEnemiesInColumn = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    killedEnemiesInColumn[j] = killedEnemiesCol(grid, i, j);
                }
                if (j == 0 || grid[i][j - 1] == 'W') {
                    killedEnemiesInRow = killedEnemiesRow(grid, i, j);
                }
                if (grid[i][j] == '0') {
                    int cur = killedEnemiesInColumn[j] +  killedEnemiesInRow;
                    max = cur > max ? cur : max;
                }
                
            }
        }
        return max;
    }
    
    private int killedEnemiesCol(char[][] grid, int i, int j) {
        int num = 0;
        while (i < grid.length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') {
                num++;
            }
            i++;
        }
        return num;
       
    }
    
    private int killedEnemiesRow(char[][] grid, int i, int j) {
        int num = 0;
        while (j < grid[0].length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') {
                num++;
            }
            j++;
        }
        return num;
    }
}