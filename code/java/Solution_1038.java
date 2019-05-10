class Solution {
    public TreeNode bstToGst (TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }
        return root;
    }
}

// recursive 
class Solution {
    public TreeNode bstToGst (TreeNode root) {
        bstToGstHelper(root, 0);
        return root;
    }
    private int bstToGstHelper (TreeNode root, int s) {
        if (root == null) {
            return 0;
        }
        int sum =  root.val + bstToGstHelper(root.right, s);
        root.val = sum  + s;
        sum += bstToGstHelper(root.left, root.val);
        return sum;   
    }
    
}