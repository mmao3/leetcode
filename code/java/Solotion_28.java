class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}

//kmp
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int[] prefix = new int[needle.length()];
        for (int i = 0, j = 1; j < prefix.length;) {
            if (needle.charAt(j) == needle.charAt(i)) {
                prefix[j++] = ++i;
            } else if (i == 0) {
                prefix[j++] = 0;
            } else {
                i = prefix[i - 1];
            }
        }
       
        for (int i = 0, j = 0; i < haystack.length();) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = prefix[j - 1];
                }
            }
            if (j == needle.length()) {
                return i - needle.length();
            }
        }
        return -1;
    }
}

