class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        int max = nums[0];
        for(int i = 0; i<n ; i++){
            max = Math.max(max, nums[i]);
            arr[i] = (long)nums[i] + (long)max;
        }
        for(int i = 1 ; i<n ; i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }
}