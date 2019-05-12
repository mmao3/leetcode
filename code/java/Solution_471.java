class Solution {
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                String substr = s.substring(i, j + 1);
                dp[i][j] = substr;
                if (j - i < 4) {
                   continue;
                } 
                for (int k = i; k < j; k++) {
                    if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
                
                String pattern = longestRepeated(substr);
                if (pattern.length() == substr.length()) {
                    continue;
                }
                String patternEncode = substr.length() / pattern.length() + "[" + dp[i][i + pattern.length() - 1] + "]";
                if (patternEncode.length() < dp[i][j].length()) {
                    dp[i][j] = patternEncode;
                }
                
            }
        }
        return dp[0][n - 1];
    }
    
    private String longestRepeated(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 0, j = 1; j < n;) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[j++] = ++i;
            } else if (i == 0) {
                lps[j++] = 0;
            } else {
                i = lps[i - 1];
            }
        }
        int patternLength = n - lps[n - 1];
        if (patternLength != n && n % patternLength == 0) {
            return s.substring(0, patternLength);
        } else {
            return s;
        }
        
    }   
