class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0; i<nums.length ; i++){
            if(nums[i] < 0) neg.add(nums[i]);
            else pos.add(nums[i]);
        }
        int[] res = new int[nums.length];
        int i = 0 ,j = 0;
        for(int x = 0; x<nums.length ; x++){
            if(x%2 != 0) res[x] = neg.get(i++);
            else res[x] = pos.get(j++);
        }
        return res;
    }
}