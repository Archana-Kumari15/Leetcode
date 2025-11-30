class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int x : nums) sum += x;
        
        int target = (int)(sum % p);
        if (target == 0) return 0; 
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        long prefix = 0;
        int ans = n;
        
        for (int j = 0; j < n; j++) {
            prefix += nums[j];
            int currMod = (int)(prefix % p);
            
            int need = (currMod - target + p) % p;
            if (map.containsKey(need)) {
                int i = map.get(need);
                ans = Math.min(ans, j - i);
            }
            map.put(currMod, j);
        }
        
        return ans == n ? -1 : ans;
    }
}