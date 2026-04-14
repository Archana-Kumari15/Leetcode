class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minkPosition = -1;
        int maxkPosition = -1;
        int culpritIdx = -1;

        for(int i = 0; i<nums.length ; i++){
            if(nums[i] < minK || nums[i] > maxK){
                culpritIdx = i;
            }
            if(nums[i] == minK) minkPosition = i;
            if(nums[i] == maxK) maxkPosition = i;
            
            long smaller = Math.min(minkPosition,maxkPosition);
            long temp = smaller - culpritIdx;
            ans += (temp<=0) ? 0 : temp;
        }
        return ans;
    }
}