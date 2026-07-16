class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int numofzeros = 0;
        int numofones = 0;
        for(int i = 0; i<n ; i++){
            if(nums[i] == 0) numofzeros++;
            if(nums[i] == 1) numofones++;
        }

        for(int i = 0; i<n ; i++){
            if(i<numofzeros) nums[i] = 0;
            else if(i < numofzeros + numofones) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}