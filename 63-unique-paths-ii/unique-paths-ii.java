class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m+1][n+1];
        if(arr[0][0] == 1) return 0;
        dp[0][0] =  1;
         for (int j = 1; j < n; j++) {
            if (arr[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            if (arr[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 0;
            }
        }
        for(int i = 1; i<m ; i++){
            for(int j = 1; j<n ; j++){
                if(arr[i][j] == 1)  dp[i][j] = 0;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}