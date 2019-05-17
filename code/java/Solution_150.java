class Solution_150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                stack.push(operate(token, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
    private int operate(String operator, int a, int b) {
        switch(operator) {
            case "+" : return a + b;
            case "-": return b - a;
            case "*": return a * b;
            case "/": return b / a;
            default: return 0;
        }
    }
}