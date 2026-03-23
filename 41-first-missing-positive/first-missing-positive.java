class Solution {
    public void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n ; i++){
            while(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i]-1]){
                swap(i,nums[i]-1,nums);
            }
        }
        for(int i = 0; i<n ; i++){
            if(nums[i] != i+1)
            return i+1;
        }
        return n+1;
    }
}