class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = 0;
        for(; i<nums.length ; i++){
           res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}