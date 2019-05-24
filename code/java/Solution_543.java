class Solution_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[]{1};
        diameterOfBinaryTree(root, max);
        return max[0] - 1;
        
    }
    
    public int diameterOfBinaryTree(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left, max);
        int right = diameterOfBinaryTree(root.right, max);
        max[0] = Math.max(max[0], 1 + left + right);
        return 1 + Math.max(left, right);
    }
}