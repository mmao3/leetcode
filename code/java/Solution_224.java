class Solution_224 {
    public int calculate(String s) {
        Deque<Integer> operand = new ArrayDeque<>();
        Deque<Character> operator = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                operand.push(val);
                i--;
            } else if (c == '(') {
                operator.push(c);
            } else if (c == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    operand.push(operate(operand, operator));
                }
                operator.pop();
            } else {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    operand.push(operate(operand, operator));
                }
                operator.push(c);
            }
        }
        while (!operator.isEmpty()) {
            operand.push(operate(operand, operator));
        }
        return operand.pop();
    }
    
    private int operate(Deque<Integer> operand, Deque<Character> operator) {
        char o = operator.pop();
        int a = operand.pop();
        int b = operand.pop();
        return o == '+' ? a + b : b - a;
    }
    
    
}