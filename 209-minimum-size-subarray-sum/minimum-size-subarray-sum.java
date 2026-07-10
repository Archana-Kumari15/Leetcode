class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int mincount = Integer.MAX_VALUE;
        
            for(; j<n ; j++){
                sum += nums[j];
                while(sum >= target){
                    mincount = Math.min(mincount,j-i+1);
                    sum -= nums[i];
                     i++;
                }
               
            }
        if(mincount == Integer.MAX_VALUE)  return 0;
        return mincount;
    }
}