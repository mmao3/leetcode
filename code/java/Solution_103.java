//bfs
class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isBackward = false;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (isBackward) {
                    l.addFirst(cur.val);
                } else {
                    l.add(cur.val);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }     
            }
            res.add(l);
            isBackward = !isBackward;
        }
        return res;
    }
}


//dfs
class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrder(root, res, 0);
        return res;
    }
    
    public void zigzagLevelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new LinkedList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            ((LinkedList)(res.get(level))).addFirst(root.val);
        }
        zigzagLevelOrder(root.left, res, level + 1);
        zigzagLevelOrder(root.right, res, level + 1);
    }
}