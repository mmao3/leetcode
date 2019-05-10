//recursive 
class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    } 
}


//iterative 
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            
        }
        return res;
    }
}

//iterator
class Solution {
    Deque<TreeNode> stack = new ArrayDeque<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();  
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (hasNext()) {
            res.add(getNext());
        }
        return res;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int getNext() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
        return node.val;
    }
}





