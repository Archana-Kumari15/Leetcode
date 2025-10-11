class Solution {
     private static int findLastIndexLE(long[] arr, long target) {
        int lo = 0, hi = arr.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
    public long maximumTotalDamage(int[] power) {
         int n = power.length;
        Map<Long, Long> totalByVal = new HashMap<>();
        for (int x : power) {
            long v = x;
            totalByVal.put(v, totalByVal.getOrDefault(v, 0L) + v);
        }
        int m = totalByVal.size();
        long[] vals = new long[m];
        long[] totals = new long[m];
        int idx = 0;
        for (Map.Entry<Long, Long> e : totalByVal.entrySet()) {
            vals[idx] = e.getKey();
            totals[idx] = e.getValue();
            idx++;
        }
        Integer[] order = new Integer[m];
        for (int i = 0; i < m; i++) order[i] = i;
        Arrays.sort(order, Comparator.comparingLong(i -> vals[i]));
        long[] svals = new long[m];
        long[] stotals = new long[m];
        for (int i = 0; i < m; i++) {
            svals[i] = vals[order[i]];
            stotals[i] = totals[order[i]];
        }
        long[] dp = new long[m];
        for (int i = 0; i < m; i++) {
            long optSkip = (i == 0) ? 0L : dp[i-1];
            long need = svals[i] - 3L;
            int j = findLastIndexLE(svals, need); 
            long optTake = stotals[i] + (j == -1 ? 0L : dp[j]);

            dp[i] = Math.max(optSkip, optTake);
        }

        return (m == 0) ? 0L : dp[m-1];
    }
}