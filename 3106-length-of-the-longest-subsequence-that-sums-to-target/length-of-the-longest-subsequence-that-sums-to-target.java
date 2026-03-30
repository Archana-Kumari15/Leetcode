class Solution {
    static int[][] dp;
    public int length(int i, int target,List<Integer> arr){
            if(target == 0) return 0;
            if(i == arr.size()) return Integer.MIN_VALUE;
        if(dp[i][target] != -1) return dp[i][target];
        int skip = length(i+1,target,arr);
        int take = Integer.MIN_VALUE;
        if (arr.get(i) <= target) {
            int res = length(i + 1, target - arr.get(i), arr);
            if (res != Integer.MIN_VALUE) {
                take = 1 + res;
            }
        }
        return dp[i][target] =  Math.max(skip,take);
    }
    public int lengthOfLongestSubsequence(List<Integer> arr, int target) {
        int n = arr.size();
        dp = new int[n][target+1];
        for(int i = 0; i<dp.length;i++){
            for(int j = 0; j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans =  length(0,target,arr);
        return ans<0 ? -1:ans;
    }
}