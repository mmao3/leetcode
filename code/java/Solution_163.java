class Solution_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int next = lower;
        List<String> res = new ArrayList<>();
        for (int num : nums) {
            if (num < next) {
                continue;
            }
            if (num > next) {
                 res.add(getRange(next, num - 1));
            }
            if (num == Integer.MAX_VALUE) {
                return res;
            }
            next = num + 1; 
        }
        if (next <= upper) {
            res.add(getRange(next, upper));
        }
        return res;
    }
    
    private String getRange(int n1, int n2) {
        return n1 == n2 ? String.valueOf(n1) : n1 + "->" + n2;
    }
}