class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k == 0) return 0;
        int count = 0;
        int i = 0;
        int pro = 1;
        for(int j = 0; j<n ; j++){
            pro *= nums[j];
            while(i<=j && pro >= k){
                pro /= nums[i];
                i++;
            }
            count += j-i+1;
        }
        return count;
    }
}