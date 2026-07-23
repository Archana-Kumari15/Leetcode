class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftsum = 0;
        int rightsum = 0;
        int totalsum = 0;
        for(int i = 0; i <n ; i++){
           totalsum += nums[i];
        }
        for(int i = 0; i<n ; i++){  
            rightsum = totalsum - leftsum - nums[i];
            if(leftsum == rightsum) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}