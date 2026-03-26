class Solution {
    public long coincount(int i,int[] coins, int amount,long[][] dp){
        if(i == -1){
           if(amount == 0) return 0;
           else return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        long skip = coincount(i-1,coins,amount,dp);
        if(amount - coins[i] < 0) return dp[i][amount] = skip;
        long pick = 1 + coincount(i,coins,amount - coins[i],dp);
        return dp[i][amount] = Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[coins.length][amount+1];
        for(int i = 0 ; i<dp.length ; i++){
            for(int j = 0; j<dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        int ans = (int)coincount(n-1,coins,amount,dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}