class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int pivot = partition(nums, i, j);
            if (pivot == k - 1) {
                return nums[pivot];
            } else if (pivot > k - 1) {
                j = pivot - 1;
            } else {
                i = pivot + 1;
            }
        }
        return nums[i];
    }
    
    private int partition(int[] nums, int i, int j) {
        int pivot = j;
        j--;
        while (i <= j) {
            if (nums[i] >= nums[pivot]) {
                i++;
            } else if (nums[j] < nums[pivot]) {
                j--;
            } else {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, i, pivot);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}