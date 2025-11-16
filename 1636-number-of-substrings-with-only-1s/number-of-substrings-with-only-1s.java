class Solution {
    public int numSub(String s) {
        final long MOD = 1_000_000_007L;
        long ans = 0;
        long currentRun = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                currentRun++;
                ans = (ans + currentRun) % MOD;
            } else {
                currentRun = 0;
            }
        }
        
        return (int) ans; 
    }
}