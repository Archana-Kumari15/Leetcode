class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        int maxVal = 100000;
        long[] right = new long[maxVal + 1];
        long[] left = new long[maxVal + 1];

        for (int x : nums) {
            right[x]++;
        }

        long result = 0;

        for (int j = 0; j < n; j++) {
            int x = nums[j];
            right[x]--;  

            int target = x * 2;
            if (target <= maxVal) {
                long countLeft = left[target];
                long countRight = right[target];

                result = (result + (countLeft * countRight) % MOD) % MOD;
            }
            left[x]++;
        }

        return (int) result;
    }
}