class Solution {
    public int path(int row,int col,Integer m,Integer n,int[][] dp){
        if(row >= m || col >=n) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int rightway = path(row,col+1,m,n,dp);
        int downway = path(row+1,col,m,n,dp);
        return dp[row][col] = rightway + downway;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return path(0,0,m,n,dp);
    }
}