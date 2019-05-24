//dfs
class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }
    
    public int lengthOfLIS(int[] nums, int prev, int curIndex) {
        if (curIndex == nums.length) {
            return 0;
        }
        int included = 0;
        if (nums[curIndex] > prev) {
            included = 1 + lengthOfLIS(nums, nums[curIndex], curIndex + 1);
        }
        int notIncluded = lengthOfLIS(nums, prev, curIndex + 1);
        return Math.max(included, notIncluded);
    }
}

//dfs + memo 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] map = new int[nums.length + 1][nums.length];
        return lengthOfLIS(nums, -1, 0, map);
    }
    
    public int lengthOfLIS(int[] nums, int prev, int curIndex, int[][] map) {
        if (curIndex == nums.length) {
            return 0;
        }
        if (map[prev + 1][curIndex] > 0) {
            return map[prev + 1][curIndex];
        }
        int included = 0;
        if (prev == -1 || nums[curIndex] > nums[prev]) {
            included = 1 + lengthOfLIS(nums, curIndex, curIndex + 1, map);
        }
        int notIncluded = lengthOfLIS(nums, prev, curIndex + 1, map);
        map[prev + 1][curIndex] = Math.max(included, notIncluded);
        return map[prev + 1][curIndex];
    }
}



// dp
class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
        
    }
}

//binary search version 1
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] tails = new int[n];
        int[] predecessors = new int[n];
        for (int i = 0; i < n; i++) {
            predecessors[i] = -1;
        }
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            int l = 0;
            int h = maxIndex;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (nums[tails[mid]] < nums[i]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
            if (l == maxIndex + 1) {
                predecessors[i] = tails[maxIndex];
                tails[++maxIndex] = i;
            } else {
                predecessors[i] = l > 0 ? tails[l - 1] : -1;
                tails[l] = i;
            }
        }
        
        // construct the longest increasing subsequence from predecessors;
        int[] lis = new int[maxIndex + 1];
        int cur = tails[maxIndex];
        int i = maxIndex;
        do {
            lis[i--] = nums[cur];
            cur = predecessors[cur];
        } while (cur != -1);
        
        return maxIndex + 1;
        
    }
}

// binary search version 2
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];
        int maxLen = 0;
        for (int num : nums) {
            int l = 0;
            int r = maxLen - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (tails[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            tails[l] = num;
            if (l == maxLen) {
                maxLen++;
            } 
        }
        return maxLen;
    }
}



