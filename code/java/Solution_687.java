// recursive
class Solution_687 {
    public int longestUnivaluePath(TreeNode root) {
        int[] max = new int[1];
        longestUnivaluePath(root, max);
        return max[0];
    }
    
    public int longestUnivaluePath(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePath(root.left, max);
        int right = longestUnivaluePath(root.right, max);
        int resL = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int resR = root.right != null && root.right.val == root.val ? right + 1 : 0; 
        max[0] = Math.max(max[0], resL + resR);
        return Math.max(resL, resR);
    }
}

//iterative 
class Solution_687 {
    public int longestUnivaluePath(TreeNode root) {
        int res = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<int[]> max = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                max.push(new int[]{0, 0});
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            TreeNode curNode = stack.pop();
            int[] curMax = max.pop();
            int l = curNode.left != null && curNode.left.val == curNode.val ? curMax[0] + 1 : 0;
            int r = curNode.right != null && curNode.right.val == curNode.val ? curMax[1] + 1 : 0;
            if (!stack.isEmpty() && stack.peek().left == curNode) {
                root = stack.peek().right;
                max.peek()[0] = Math.max(l, r);
            } else if (!stack.isEmpty()) {
                max.peek()[1] = Math.max(l, r);
             } 
            res = Math.max(res, l + r);
        }
        return res;
    }
}
