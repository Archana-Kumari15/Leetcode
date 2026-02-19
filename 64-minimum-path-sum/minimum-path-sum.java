class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j<n ; j++){
                if(i == 0 && j == 0){
                    cost[i][j] = grid[i][j];
                }else{
                    int up = (i>0) ? cost[i-1][j] : Integer.MAX_VALUE;
                    int left = (j>0) ? cost[i][j-1] : Integer.MAX_VALUE;
                 cost[i][j] = grid[i][j] + Math.min(up,left);
                 }
            }
        }
        return cost[m-1][n-1];
    }
}