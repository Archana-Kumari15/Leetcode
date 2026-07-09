class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
        int l = i+1;
        int r = nums.length - 1;
        if(i>0 && nums[i] == nums[i-1]) continue;
        while(l < r){
            int fixed = nums[i];
            int need = -fixed;
            if(nums[l] + nums[r] < need) l++;
            else if(nums[l] + nums[r] > need) r--;
            else{
                res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                l++;
                r--;
                while(l < r && nums[l] == nums[l-1]) l++;
                while(l < r && nums[r] == nums[r+1]) r--;
            }
            }   
          }
        return res;
    }
}