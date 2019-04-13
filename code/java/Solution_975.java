class Solution_975 {
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        boolean[] evenJump = new boolean[n];
        boolean[] oddJump = new boolean[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        evenJump[n - 1] = oddJump[n - 1] = true;
        int count = 1;
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry higher = map.ceilingEntry(A[i]);
            Map.Entry lower = map.floorEntry(A[i]);
            if (higher != null) {
                oddJump[i] = evenJump[(int)higher.getValue()];
            }
            if (lower != null) {
                evenJump[i] = oddJump[(int)lower.getValue()];
            }
            map.put(A[i], i);
            if (oddJump[i]) {
                count++;
            }
        }
        return count;
    }
}