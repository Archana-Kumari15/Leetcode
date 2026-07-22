class Solution {
    public int atmost(int[] nums, int k){
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int count = 0;
        for(int j = 0; j < n ; j++){
            map.put(nums[j],map.getOrDefault(nums[j],0) + 1);
            while(map.size() > k){
                map.put(nums[i],map.getOrDefault(nums[i],0) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            count += j-i+1;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atmost(nums,k) - atmost(nums,k-1);
    }
}