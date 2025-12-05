class Solution {
    public int countPartitions(int[] nums) {
      int left = 0;
        int total = 0;
        int count = 0;
        for (int x : nums) {
            total += x;
        }
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            if (left == total) break;
            if (Math.abs(total - 2 * left) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}