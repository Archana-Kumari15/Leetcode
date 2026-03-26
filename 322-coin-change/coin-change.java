class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[coins.length][amount+1];
        for(int i = 0 ; i<dp.length ; i++){
            for(int j = 0; j<dp[0].length ; j++){
                long skip = (i>0) ? dp[i-1][j] : ((j==0) ? 0 : Integer.MAX_VALUE);
                if(j - coins[i] < 0) dp[i][j] = skip;
                else{
                long pick = 1 + dp[i][j-coins[i]];
                dp[i][j] = Math.min(pick,skip);
                }
            }
        }
        int ans = (int)dp[n-1][amount];
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}