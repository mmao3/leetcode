//dfs
class Solution_568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        return maxVacationDays(flights, days, 0, 0);
        
    }
    
    private int maxVacationDays(int[][] flights, int[][] days, int cur_city, int weekno) {
        if (weekno == days[0].length) {
            return 0;
        }
        int maxvac = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[cur_city][i] == 1 || i == cur_city) {
                int vac = days[i][weekno] + maxVacationDays(flights, days, i, weekno + 1);
                maxvac = Math.max(maxvac, vac);
            }
            
        }
        return maxvac;
        
    }
}

//dfs + memo
class Solution_568_1 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] memo = new int[flights.length][days[0].length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return maxVacationDays(flights, days, 0, 0, memo);
        
    }
    
    private int maxVacationDays(int[][] flights, int[][] days, int cur_city, int weekno, int[][] memo) {
        if (weekno == days[0].length) {
            return 0;
        }
        if (memo[cur_city][weekno] >= 0) {
            return memo[cur_city][weekno];
        }
        int maxvac = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[cur_city][i] == 1 || i == cur_city) {
                int vac = days[i][weekno] + maxVacationDays(flights, days, i, weekno + 1, memo);
                maxvac = Math.max(maxvac, vac);
            }
            
        }
        memo[cur_city][weekno] = maxvac;
        return maxvac;
        
    }
}


//dp 
class Solution_568_2 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int numOfcities = flights.length;
        int numOfweeks = days[0].length;
        int[] dp = new int[numOfcities];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < numOfweeks; i++) {
            int[] cur = new int[numOfcities];
            Arrays.fill(cur, Integer.MIN_VALUE);
            for (int j = 0; j < numOfcities; j++) {
                for (int k = 0; k < numOfcities; k++) {
                    if (k == j || flights[k][j] == 1) {
                        cur[j] = Math.max(dp[k] + days[j][i], cur[j]);
                    } 
                }
            }
            dp = cur;
        }
        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }
        return max;
        
    }
}