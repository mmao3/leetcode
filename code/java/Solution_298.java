class Solution_298 {
    public int longestConsecutive(TreeNode root) {
        int[] max = {0};
        longestConsecutive(root, max);
        return max[0];
    }
    private int longestConsecutive(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int curMax = 1;
        int left = longestConsecutive(root.left, max);
        int right = longestConsecutive(root.right, max);
        if (root.left != null && root.val == root.left.val - 1) {
            curMax = Math.max(left + 1, curMax);
        }
        if (root.right != null && root.val == root.right.val - 1) {
           
            curMax = Math.max(right + 1, curMax);
        }
        max[0] = Math.max(max[0], curMax);
        return curMax;
    }
}