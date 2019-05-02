class Solution_345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int i = 0;
        int j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
            if (!isVowel(charArray[i])) {
                i++;
            } else if (!isVowel(charArray[j])) {
                j--;
            } else {
                char tem = charArray[i];
                charArray[i++] = charArray[j];
                charArray[j--] = tem;
            }
        }
        return new String(charArray);
    }
    private boolean isVowel(char c) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char v : vowels) {
            if (c == v) {
                return true;
            }
        }
        return false;
    }
}