class Solution_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int happy = 0;
        int max = 0;
        int window = 0;
        for (int i = 0; i < customers.length; i++) {
            window += customers[i] * grumpy[i];
            if (i >= X) {
                window -= customers[i - X] * grumpy[i - X];
            }
            max = Math.max(window, max);
            if (grumpy[i] == 0) {
                happy += customers[i];
            }
        }
        return happy + max;
        
    }
}