class Solution {
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int downMoves = Math.min(m - 1, n - 1); 
        long result = 1;
        for (int i = 1; i <= downMoves; i++) {
            result = result * (total - downMoves + i) / i;
        }
        return (int) result;
    }
}
