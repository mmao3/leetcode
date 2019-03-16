public class Solution_388 {
	public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int res = 0;
        String[] paths = input.split("\n");
        for (String path : paths) {
            int level = path.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = path.length() + stack.peek() - level + 1;
            stack.push(len);
            if (path.contains(".")) {
                res = Math.max(res, len - 1);  
            }
            
        }
        return res;  
    }
}


