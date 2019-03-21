class Solution_271 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.replace("#", "##")).append(" # ");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strs = s.split(" # ", -1);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < strs.length - 1; i++) {
            res.add(strs[i].replace("##", "#"));
        }
        return res;
    }
}
