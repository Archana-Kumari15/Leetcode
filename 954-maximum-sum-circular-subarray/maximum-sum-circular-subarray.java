class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxsum = nums[0];
        int minsum = nums[0];
        int currminsum = nums[0];
        int currmaxsum = nums[0];
        int totalsum = 0;
        int ans = 0;
        for(int i = 0; i<n ; i++){
            totalsum += nums[i];
        }
        for(int i = 1; i<n ; i++){
            currmaxsum = Math.max(nums[i], currmaxsum + nums[i]);
            maxsum = Math.max(currmaxsum, maxsum);
            currminsum = Math.min(nums[i], currminsum + nums[i]);
            minsum = Math.min(currminsum, minsum);
        }
        if(maxsum < 0) return maxsum;
        return Math.max(maxsum, totalsum - minsum);
    }
}