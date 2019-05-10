// recursive
class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }
    public void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}

//iterative 

class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            res.add(cur.val);
            root = cur.right;
        }
        return res;
    }
}

//iterator 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution_94 {
    Deque<TreeNode> stack = new ArrayDeque<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        findLeft(root);
        while(hasNext()) {
            res.add(getNext());
        }
        return res;
    }
    
    public void findLeft(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    public int getNext() {
        TreeNode node = stack.pop();
        int val = node.val;
        findLeft(node.right);
        return val;
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}



