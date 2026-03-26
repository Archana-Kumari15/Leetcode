class Solution {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i<arr.length ; i++) sum += arr[i];
        if(sum % 2 != 0) return false;
        int target = sum/2;
        int[][] dp = new int[arr.length][target+1];
        for(int i = 0; i<dp.length;i++){
            for(int j = 0; j<dp[0].length;j++){
                boolean ans = false;
                boolean skip = (i>0) ? (dp[i-1][j] == 1) : (j == 0);
                if(j-arr[i] < 0) ans = skip;
                else{
                boolean pick = (i>0) ? (dp[i-1][j-arr[i]] == 1) : (j == 0);
                ans = skip || pick;
            }
                dp[i][j] = (ans) ? 1 : 0;
            }
        }
        return dp[n-1][target] == 1;
    }
}