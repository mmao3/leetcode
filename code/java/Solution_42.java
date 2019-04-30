// stack 
class Solution_42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int cur = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[stack.peek()]) - height[cur];
                    total += h * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return total;
        
        
    }
}


//two pointer
class Solution_42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int total = 0;
        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] < maxLeft) {
                    total += maxLeft - height[left];
                } else {
                    maxLeft = height[left];
                }
                left++;
                
            } else {
                if (height[right] < maxRight) {
                    total += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                right--;
            }
            
        }
        return total;
        
        
    }
}