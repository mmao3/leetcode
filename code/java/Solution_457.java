class Solution_457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = next(i, nums);
            while (nums[fast] * nums[i] > 0 && nums[i] * nums[next(fast, nums)] > 0) {
                if (fast == slow) {
                    if (fast == next(fast, nums)) {
                        break;
                    }
                    return true;
                }
                slow = next(slow, nums);
                fast = next(next(fast, nums), nums);
            }
            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = next(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }
    
    private int next(int i, int[] nums) {
        return ((i + nums[i]) % nums.length + nums.length) % nums.length;
    }
}