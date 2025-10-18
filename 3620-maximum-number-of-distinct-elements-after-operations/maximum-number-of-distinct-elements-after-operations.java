class Solution {
    public int maxDistinctElements(int[] nums, int k) {
         int n = nums.length;
        long K = k; 
        long[][] intervals = new long[n][2];
        for (int i = 0; i < n; i++) {
            long a = nums[i];
            intervals[i][0] = a - K; 
            intervals[i][1] = a + K;
        }
        Arrays.sort(intervals, (x, y) -> {
            if (x[1] == y[1]) return Long.compare(x[0], y[0]);
            return Long.compare(x[1], y[1]);
        });
        
        long cur = Long.MIN_VALUE / 4; 
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            long left = intervals[i][0];
            long right = intervals[i][1];
            if (cur < left) cur = left;
            if (cur <= right) {
                count++;
                cur++; 
            }
        }
        
        return count;
    }
}