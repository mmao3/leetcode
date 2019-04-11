public class Solution_281 {
    Queue<Integer> q;
    int index;
    List<List<Integer>> list;
    int maxLength;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        list = new LinkedList<>();
        list.add(v1);
        list.add(v2);
        index = 0;
        maxLength = Math.max(v1.size(), v2.size());
    }

    public int next() {
        if (!q.isEmpty()) {
            return q.poll();
        }
        for (List<Integer> l : list) {
            if (index < l.size()) {
                q.offer(l.get(index));
            }
        }
        index++;
        return next();
        
    }

    public boolean hasNext() {
        return !q.isEmpty() || index < maxLength;
        
    }
}

public class ZigzagIterator {
    LinkedList<Iterator<Integer>> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty()) {
            list.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            list.add(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> cur = list.remove();
        int res = cur.next();
        if (cur.hasNext()) {
            list.add(cur);
        }
        return res;
        
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
