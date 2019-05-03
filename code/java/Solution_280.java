class Solution_280 {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
               swap(nums, i, i + 1);
            } 
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}

// solution 2 bucket sort
class Solution_280 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int citation : citations) {
            count[Math.min(n, citation)]++;
        }
        int s = 0;
        for (int i = n; i >= 0; i--) {
            s += count[i];
            if (s >= i) {
                return i;
            }
        }
        return 0;
    }
        
}

