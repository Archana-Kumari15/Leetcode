class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currmaxsum = nums[0];
        int currminsum = nums[0];
        int maxsum = nums[0];
        int minsum = nums[0];
        int ans = nums[0];
        for(int i = 1; i<n ; i++){
            currmaxsum = Math.max(nums[i] , nums[i] + currmaxsum);
            maxsum = Math.max(maxsum, currmaxsum);
            currminsum = Math.min(nums[i], nums[i] + currminsum);
            minsum = Math.min(minsum , currminsum);
            ans = Math.max(ans,Math.max(maxsum,Math.abs(minsum)));
        }
        return ans > 0 ? ans : Math.abs(ans);
    }
}