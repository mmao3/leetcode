// solution 1 Interate over time
public class Solution_683 {
	public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0 || k < 0) {
            return -1;
        }
        int n = flowers.length;
        TreeSet<Integer> active = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int pos = flowers[i];
            Integer l = active.lower(pos);
            Integer u = active.higher(pos);
            if (l != null && l  == pos - k - 1 || u != null && u == pos + k + 1) {
                return i + 1;
            }
            active.add(pos);
        }
        return -1;
    }
}


// solution 2 Interate over position
public class Solution_683_1 {
	public int kEmptySlots(int[] flowers, int k) {
        public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0 || k < 0) {
            return -1;
        }
        int n = flowers.length;
        int res = n + 1;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[flowers[i] - 1] = i + 1;
        }
        for (int l = 0, r = k + 1, i = 0; i < n && r < n; i++) {
            int di = days[i], dl = days[l], dr = days[r];
            if (di < dl || di <= dr) {
                if (di == dr) {
                    res = Math.min(res, Math.max(dl, dr));
                }
                l = i;
                r = i + k + 1;
            }
        }
        return res == n + 1 ? - 1 : res;
    }
    }
}
