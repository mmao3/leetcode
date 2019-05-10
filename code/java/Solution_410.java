// DFS + memo
class Solution_410 {
    public int splitArray(int[] nums, int m) {
        int[][] map = new int[nums.length][m];
        return splitArray(nums, 0, m, map);
    }
    
    public int splitArray(int nums[], int l, int m, int[][] map) {
        if (map[l][m - 1] > 0) {
            return map[l][m - 1];
        }
        if (m == 1) {
            int sum = 0;
            for (int i = l; i < nums.length; i++) {
                sum += nums[i];
            }
            map[l][0] = sum;
            return sum;
        }
        int min = Integer.MAX_VALUE;
        int sum = nums[l];
        for (int i = l + 1; i < nums.length; i++) {
            min = Math.min(min, Math.max(sum, splitArray(nums, i, m - 1, map)));
            sum += nums[i];
        }
        map[l][m - 1] = min;
        return min;
    }
}

// DP
class Solution_410S {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = i == 0 ? nums[0] : dp[i - 1][0] + nums[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int min = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k >= 1; k--) {
                    sum += nums[k];
                    min = Math.min(min, Math.max(sum, dp[k - 1][j - 1]));
                    
                }
                dp[i][j] = min;
                
            }
            
        }
        return dp[n - 1][m - 1];
    }
}

// binary search 

class Solution {
    public int splitArray(int[] nums, int m) {
        long l = 0;
        long h = 0;
        for (int num : nums) {
            l = Math.max(num, l);
            h += num;
        }
        while (l < h) {
            long mid = l + (h - l) / 2;
            if (isValid(nums, mid, m - 1)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int)h;
    }
    private boolean isValid(int[] nums, long val, int m) {
        int sum = 0;
        for (int num : nums) {
            if (num > val) {
                return false;
            } else if (num + sum <= val) {
                sum += num;
            } else {
                m--;
                if (m < 0) {
                    return false;
                }
                sum = num;
            }  
        }
        return true;
    }
}