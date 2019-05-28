class Solution_1053 {
    public int[] prevPermOpt1(int[] A) {
        int n = A.length;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                int j = n - 1;
                while (A[j] >= A[i]) {
                    j--;
                }
                while (A[j - 1] == A[j]) {
                    j--;
                    
                }
                swap(i, j, A);
                break;
            }
            
        }
        return A;  
    }
    public void swap(int i, int j, int[] A) {
        int tem = A[i];
        A[i] = A[j];
        A[j] = tem;
    }
}