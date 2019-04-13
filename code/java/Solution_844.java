class Solution_844 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    public String build(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return String.valueOf(stack);
    }
}

class Solution_844_1 {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) {
            return S == T;
        }
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (skipS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') {
                    skipS++;
                } else {
                    skipS--;
                }
                i--;
            }
            while (j >= 0 && (skipT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') {
                    skipT++;
                } else {
                    skipT--;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == j;
            }
        }
        return true;
        
    }
}