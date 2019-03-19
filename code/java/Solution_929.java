class Solution_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0].replaceAll("\\.", "");
            normalized.add(local + "@" + parts[1]);
        }
        return normalized.size();
    }
}