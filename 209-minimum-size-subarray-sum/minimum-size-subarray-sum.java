class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, length = 0;
        int minlength = Integer.MAX_VALUE;
        while(j<n){
            length += nums[j];
            while(length >= target){
                minlength = Math.min(minlength,j-i+1);
                length -= nums[i];
                i++;
            }
            j++;
        }
        return minlength == Integer.MAX_VALUE ? 0 : minlength;
    }
}