class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
         if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int maxVal = 0;
        for (int v : nums) if (v > maxVal) maxVal = v;
        int[] freq = new int[maxVal + 1];
        for (int v : nums) freq[v]++;

        int[] pref = new int[maxVal + 1];
        pref[0] = freq[0];
        for (int v = 1; v <= maxVal; v++) pref[v] = pref[v - 1] + freq[v];

        int ans = 0;
        for (int t = 0; t <= maxVal; t++) {
            if (freq[t] == 0 && numOperations == 0) {
                continue;
            }
            int left = t - k;
            int right = t + k;
            if (right < 0 || left > maxVal) {
                continue;
            }
            left = Math.max(0, left);
            right = Math.min(maxVal, right);

            int intervalCount = pref[right] - (left > 0 ? pref[left - 1] : 0);
            if (intervalCount == 0) continue;

            int already = freq[t];
            int candidate = Math.min(already + numOperations, intervalCount);
            if (candidate > ans) ans = candidate;
            if (ans == n) return n;
        }
        return ans;
    }
}