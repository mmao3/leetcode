class Solution_394 {
    public String decodeString(String s) {
        Deque<String> resStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = Character.getNumericValue(c);
                while (Character.isDigit(s.charAt(i + 1))) {
                    count = 10 * count + Character.getNumericValue(s.charAt(i + 1));
                    i++;
                }
                countStack.push(count);
            } else if (c == '[') {
                resStack.push(res.toString());
                res.setLength(0);
            } else if (c == ']') {
                StringBuilder prevRes = new StringBuilder(resStack.pop());
                int count = countStack.pop();
                for (int j = 0; j < count; j++) {
                    prevRes.append(res);
                }
                res = prevRes;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}