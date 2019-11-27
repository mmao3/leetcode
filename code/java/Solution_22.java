class Solution_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, 0, 0, n, new StringBuilder());
        return res;
    }
    
    public void generateParenthesis(List<String> res, int left, int right, int n, StringBuilder sb) {
        if (right == n) {
            res.add(sb.toString());
            return;
        }
        if (right < left) {
            sb.append(')');
            generateParenthesis(res, left, right + 1, n, sb);
            sb.setLength(sb.length() - 1);
        } 
        if (left < n) {
            sb.append('(');
            generateParenthesis(res, left + 1, right, n, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}