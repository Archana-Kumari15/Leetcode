class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) prefix[i + 1] = prefix[i] + stations[i];
        long[] power = new long[n];
        for (int i = 0; i < n; ++i) {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            power[i] = prefix[R + 1] - prefix[L];
        }
        long low = 0, high = prefix[n] + k; 
        while (low < high) {
            long mid = (low + high + 1) >>> 1; 
            if (canAchieve(power, r, k, mid)) low = mid;
            else high = mid - 1;
        }
        return low;
    }
    private boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] diff = new long[n + 1]; 
        long windowAdded = 0L; 
        long used = 0L;

        for (int i = 0; i < n; ++i) {
            windowAdded += diff[i];
            long curr = power[i] + windowAdded;
            if (curr < target) {
                long need = target - curr;
                used += need;
                if (used > k) return false;
                int p = Math.min(n - 1, i + r);
                int L = Math.max(0, p - r);
                int R = Math.min(n - 1, p + r);
                diff[L] += need;
                diff[R + 1] -= need;
                windowAdded += need;
            }
        }
        return true;
    }
}