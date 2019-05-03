class Solution_247 {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, n);
    }
    
    private List<String> findStrobogrammatic(int n, int m) {
        if (m == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (m == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        List<String> res = new ArrayList<>();
        List<String> list = findStrobogrammatic(n, m - 2);
        for (String s : list) {
            if (m != n) {
                res.add('0' + s + '0');
            }
            res.add('1' + s + '1');
            res.add('8' + s + '8');
            res.add('6' + s + '9');
            res.add('9' + s + '6');
        }
        return res;
    }
}