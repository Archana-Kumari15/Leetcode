class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for(int k = n-1; k>=2 ; k--){
        int i = 0;
        int j = k-1;
        int max = nums[k];
        while(i < j){
            if(nums[i] + nums[j] > max){
                int len = j-i;
                count += len;
                j--;
            }else{
                
                i++;
            }
        }
        }
        return count;
    }
}