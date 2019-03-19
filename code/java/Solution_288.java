class Solution_288 {
    Map<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String abbr = toAbbr(s);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<>());
            }
            map.get(abbr).add(s);
        }
        
    }
    
    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Set<String> set = map.get(abbr);
        return set == null || set.size() == 1 && set.contains(word);    
    }
    
    private String toAbbr(String s) {
        if (s.length() <= 2) {
            return s;
        }
        return s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
    }
}
