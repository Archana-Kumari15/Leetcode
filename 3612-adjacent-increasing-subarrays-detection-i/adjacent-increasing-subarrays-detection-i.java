class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
         if (nums == null) return false;
         int n = nums.size();
         if (n == 0) return false;
         if (2 * k > n) return false; 
         int[] len = new int[n];
         len[n - 1] = 1;
         for (int i = n - 2; i >= 0; i--) {
             if (nums.get(i) < nums.get(i + 1)) {
             len[i] = len[i + 1] + 1;
         } else {
            len[i] = 1;
        }
    }
        for (int i = 0; i <= n - 2 * k; i++) {
             if (len[i] >= k && len[i + k] >= k) {
             return true;
        }
    }
    return false;
    }
}