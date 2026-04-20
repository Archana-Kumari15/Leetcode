class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int j = 0, i = 0;
        int maxl = 0;
        int lastZeroIdx = -1;
        int result = 0;
        while(j < n){
            if(nums[j] == 0){
                i = lastZeroIdx + 1;
                lastZeroIdx = j;
            }
            maxl = Math.max(maxl,j-i);
            j++;
        }
        return maxl;
    }
}