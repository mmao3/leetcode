//sliding window solution 
class Solution_904 {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        int maxAmount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < tree.length; j++) {
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) == 0) {
                    map.remove(tree[i]);
                }
                i++;
            }
            maxAmount = Math.max(j - i + 1, maxAmount);
        }
        return maxAmount;
    }
}

//second solution 
class Solution_904_1 {
	public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        int maxAmount = 0;
        int count = 0;
        for (int i = 0, first = 0, second = -1; i < tree.length; i++) {
            ++count;
            if (tree[i] == tree[first]) {
                first = i;
            } else if (second == - 1 || tree[i] == tree[second]) {
                second = i;
            } else {
                maxAmount = Math.max(maxAmount, count - 1);
                count = Math.abs(second - first) + 1;
                first = i - 1;
                second = i;
            }
        }
        return Math.max(maxAmount, count);
    } 
}