class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "NAN";
        }
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            res.append('-');
        }
        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);
        res.append(dividend / divisor);
        long reminder = dividend % divisor;
        if (reminder == 0) {
            return res.toString();
        }
        res.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                res.insert(map.get(reminder), "(").append(')');
                return res.toString();
            }
            map.put(reminder, res.length());
            reminder *= 10;
            res.append(reminder / divisor);
            reminder = reminder % divisor;
        }
        return res.toString();  
    }
}