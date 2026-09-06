class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] arr = {-1,-1};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n ; i++){
            int curr = target - nums[i];
            if(map.containsKey(curr)){
                arr[0] = map.get(curr);
                arr[1] = i;
            }
            map.put(nums[i],i);
        }
        return arr;
    }
}