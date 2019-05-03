/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h < 0) {
            return 0;
        }
        int h_right = height(root.right);
        if (h_right == h - 1) {
            return (1 << h) + countNodes(root.right);
        } else {
            return (1 << h - 1) + countNodes(root.left);
        }
        
    }
    
    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}