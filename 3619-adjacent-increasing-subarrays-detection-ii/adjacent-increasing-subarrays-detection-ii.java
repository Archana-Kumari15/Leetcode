class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        if (nums == null) return 0;
        int n = nums.size();
        if (n < 2) return 0;      
        int maxK = n / 2; 
        int[] len = new int[n];
        len[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) len[i] = len[i + 1] + 1;
            else len[i] = 1;
        }
        int low = 1, high = maxK, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(len, mid)) {
                ans = mid;      
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public boolean isFeasible(int[] len, int k) {
        int n = len.length;
        int lastStart = n - 2 * k; 
        if (lastStart < 0) return false;
        for (int i = 0; i <= lastStart; i++) {
            if (len[i] >= k && len[i + k] >= k) return true;
        }
        return false;
    }
}