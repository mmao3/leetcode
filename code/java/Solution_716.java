// solution 1. 
class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
        
    }
    
    public void push(int x) {
        stack.push(x);
        maxStack.push(maxStack.isEmpty() ? x : Math.max(x, maxStack.peek()));
        
    }
    
    public int pop() {
        int val = stack.pop();
        maxStack.pop();
        return val;
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int peekMax() {
        return maxStack.peek();
        
    }
    
    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer = new ArrayDeque<>();
        while (top() != max) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
        
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();


 */


class MaxStack {
    TreeMap<Integer, List<Node>> map;
    DLinkedList dLinkedList;

    /** initialize your data structure here. */
    public MaxStack() {
        map = new TreeMap<>();
        dLinkedList = new DLinkedList();
        
    }
    
    public void push(int x) {
        Node node = new Node(x);
        dLinkedList.add(node);
        map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
        
    }
    
    public int pop() {
        Node node = dLinkedList.removeLast();
        List<Node> list = map.get(node.val);
        list.remove(list.size() - 1);
        if (list.size() == 0) {
            map.remove(node.val);
        }
        return node.val;
        
    }
    
    public int top() {
        return dLinkedList.last().val;
        
    }
    
    public int peekMax() {
        return map.lastKey();
        
    }
    
    public int popMax() {
        int max = peekMax();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size() - 1);
        if (list.size() == 0) {
            map.remove(max);
        }
        dLinkedList.remove(node);
        return max;
        
    }
}

class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val) {
        this.val = val;
    }
}

class DLinkedList {
    Node head;
    Node tail;
    
    public DLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
    
    public Node removeLast() {
        return remove(tail.prev);
    }
    
     public Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }
    
    public Node last() {
        return tail.prev;
    }
    
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */