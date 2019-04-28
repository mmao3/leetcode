class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);
        int x = array[1] - array[0];
        int y = array[2] - array[1];
        int min = x == 1 && y == 1 ? 0 : (x <= 2 || y <= 2 ? 1 : 2);
        int max = x - 1 + y - 1;
        return new int[]{min, max};
    }
}