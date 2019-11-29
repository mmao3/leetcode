class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        return list.stream().mapToInt(k->k).toArray();
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int num : nums1) {
           map.put(num, map.getOrDefault(num, 0) + 1);
       }
       List<Integer> intersection = new ArrayList<>();
       for (int num : nums2) {
           if (map.containsKey(num) && map.get(num) > 0) {
               intersection.add(num);
               map.put(num, map.get(num) - 1);
           }
       }
       int[] res = new int[intersection.size()];
       int index = 0;
       for (int num : intersection) {
           res[index++] = num;
       }
       return res;
    }
}