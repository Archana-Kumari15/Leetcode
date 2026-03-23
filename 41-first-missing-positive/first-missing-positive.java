class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int arr : nums){
            set.add(arr);
        }
        for(int i = 1; i<=n ; i++){
            if(!set.contains(i)) return i;
        }
        return n+1;
    }
}