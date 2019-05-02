class Solution_734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }
        HashMap<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            map.computeIfAbsent(pair.get(0), (k) -> new HashSet<>()).add(pair.get(1));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!(map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i]) || map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i]) || words1[i].equals(words2[i]))) {
                return false;
            }
        }
        return true;
        
    }
}