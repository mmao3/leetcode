class LRUCache_146 {
    DLinkedList dl;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        map = new HashMap<>();
        dl = new DLinkedList();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } 
        Node node = map.get(key);
        dl.remove(node);
        dl.addFirst(node);
        return node.value; 
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() == capacity) {
            Node node = dl.removeLast();
            map.remove(node.key);
        }
        dl.remove(map.get(key));
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        dl.addFirst(newNode); 
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DLinkedList {
    Node head;
    Node tail;
    DLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }
    
    public void addFirst(Node node) {
        if (node == null) {
            return;
        }
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    
    public Node remove(Node node) {
        if (node == null) {
            return null;
        }
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.next = null;
        node.pre = null;
        return node;
    }
    
    public Node removeLast() {
        if (head.next == tail) {
            return null;
        }
        return remove(tail.pre);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */