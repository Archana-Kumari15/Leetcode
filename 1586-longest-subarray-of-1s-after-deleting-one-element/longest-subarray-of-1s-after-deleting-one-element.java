class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int countZero = 0;
        int maxL = 0;
        for(int j = 0; j<n ; j++){
            if(nums[j] == 0) countZero++;
        while(countZero > 1){
            if(nums[i] == 0) countZero--;
            i++;
        }
        maxL = Math.max(maxL,j-i);
        }
        return maxL;
    }
}