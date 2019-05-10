//recursive
class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }
    
    public void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }
}

//iterative 
class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (!stack.isEmpty() && cur == stack.peek().left) {
                root = stack.peek().right;
            }
        }
        return res;
    }
}

//iterator 
class Solution {
    Deque<TreeNode> stack = new ArrayDeque<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        findLeaf(root);
        while (hasNext()) {
            res.add(getNext());
        }
        return res;
    }
    public void findLeaf(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int getNext() {
        TreeNode node = stack.pop();
        if (!stack.isEmpty() && node == stack.peek().left) {
            findLeaf(stack.peek().right);
        }
        return node.val;
    }
}




