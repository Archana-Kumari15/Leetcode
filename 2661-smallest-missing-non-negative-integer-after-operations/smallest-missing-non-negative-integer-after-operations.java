class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] counts = new int[value];
        for (int x : nums) {
            int r = ((x % value) + value) % value;
            counts[r]++;
        }
        int mex = 0;
        while (true) {
            int r = mex % value;
            if (counts[r] > 0) {
                counts[r]--;
                mex++;
            } else {
                return mex;
            }
        }
    }
}