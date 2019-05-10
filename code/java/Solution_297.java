public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#').append(" ");
            return;
        }
        sb.append(root.val).append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(" ");
        return deserialize(nodes, new int[1]);
    }
    
    public TreeNode deserialize(String[] nodes, int[] index) {
        String cur = nodes[index[0]++];
        if (cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = deserialize(nodes, index);
        root.right = deserialize(nodes, index);
        return root;
    }
}
