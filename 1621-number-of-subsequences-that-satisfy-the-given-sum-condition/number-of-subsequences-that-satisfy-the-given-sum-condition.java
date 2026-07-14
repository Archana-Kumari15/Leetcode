class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = n-1;
        double count = 0;
        int[] power = new int[n];
        power[0] = 1;

        for(int k = 1; k < n; k++){
             power[k] = (power[k-1] * 2) % MOD;
         }
        while(i <= j){
            if(nums[i] + nums[j] <= target){
                count = (count + power[j-i]) % MOD;
                i++;
            }else  
                j--;
          
        }
        
        return (int)count;
    }
}