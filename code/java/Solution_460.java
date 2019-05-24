class LFUCache_460 {
    DLinkedList dLinkedList;
    int capacity;
    Map<Integer, Node> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        dLinkedList = new DLinkedList();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int val = node.get(key);
        node.remove(key);
        addNewFreqNextTo(node);
        node.next.add(key, val);
        map.put(key, node.next);
        if (node.isEmpty()) {
            dLinkedList.remove(node);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!map.containsKey(key) && map.size() == capacity) {
            int k = dLinkedList.first().remove();
            map.remove(k);
            if (dLinkedList.first().isEmpty()) {
                dLinkedList.remove(dLinkedList.first());
            }
        }
        Node node = map.get(key);
        if (node != null) {
            node.remove(key);
            addNewFreqNextTo(node);
            node.next.add(key, value);
            map.put(key, node.next);
            if (node.isEmpty()) {
                dLinkedList.remove(node);
            }
        } else {
            if (dLinkedList.isEmpty() || dLinkedList.first().freq != 1) {
                dLinkedList.addFirst(new Node());
            }
            dLinkedList.first().add(key, value);
            map.put(key, dLinkedList.first());
        }
    }
    
    private void addNewFreqNextTo(Node node) {
        if (dLinkedList.isTail(node) || node.freq + 1 != node.next.freq) {
            Node newNode = new Node();
            newNode.freq = node.freq + 1;
            dLinkedList.insertAfter(node, newNode);
        }
    }
}

class Node {
    int freq;
    Map<Integer, Integer> map;
    Node next;
    Node prev;
    public Node() {
        map = new LinkedHashMap<>();
        freq = 1;
    }
    
    public int remove() {
        if (map.isEmpty()) {
            return -1;
        }
        Map.Entry<Integer, Integer> first = map.entrySet().iterator().next();
        map.remove(first.getKey());
        return first.getKey();
    }
    
    public void add(int key, int value) {
        map.put(key, value);
    }
    
    public int get(int key) {
        return map.get(key);
    }
    
    public int remove(int key) {
       return map.remove(key);
    }
    
    public boolean isEmpty() {
        return map.isEmpty();
    }
}

class DLinkedList {
    Node head;
    Node tail;
    
    public DLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public void addFirst(Node node) {
        insertAfter(head, node);
    }
    
    public Node first() {
        return head.next == tail ? null : head.next;
    }
    
    public void insertAfter(Node node, Node newNode) {
        if (node == null || newNode == null) {
            return;
        }
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
        newNode.prev = node;
    }
    
    public Node remove(Node node) {
        if (node == null) {
            return null;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }
    
    public boolean isEmpty() {
        return head.next == tail;
    }
    
    public boolean isTail(Node node) {
        return node == tail;
    }
    
    public String toString() {
        Node cur = head.next;
        StringBuilder sb = new StringBuilder();
        while (cur != tail) {
            sb.append("count " + cur.freq);
            for (Map.Entry<Integer, Integer> entry : cur.map.entrySet()) {
                sb.append("key " + entry.getKey() + " value " + entry.getValue());
            }
            cur = cur.next;
        }
        return "";
    }
}
