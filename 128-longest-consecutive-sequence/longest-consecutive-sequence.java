class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num : nums){
            set.add(num);
        }
        
        for(int num : set){
           if(!set.contains(num - 1)){
              int curr = num;
              int len = 1;
              while(set.contains(curr + 1)){
                curr += 1;
                len++;
           }
           max = Math.max(max,len);
           }
        }
        return max;
    }
}