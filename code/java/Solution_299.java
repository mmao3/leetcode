class Solution_299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] map = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bulls++;
            } else {
                if (map[s] < 0) {
                    cows++;
                }
                if (map[g] > 0) {
                    cows++;
                }
                map[s]++;
                map[g]--;
            }
        }
        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();
    }
}