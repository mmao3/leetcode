class Solution_249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            int offset = s.charAt(0) - 'a';
            StringBuilder key = new StringBuilder(s);
            for (int i = 0; i < key.length(); i++) {
                char c = (char)(key.charAt(i) - offset);
                key.setCharAt(i, c < 'a' ? c += 26 : c);
            }
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
        
    }
}