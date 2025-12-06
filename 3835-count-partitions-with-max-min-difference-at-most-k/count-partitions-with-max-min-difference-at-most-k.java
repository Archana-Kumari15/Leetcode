class Solution {
     static final long MOD = 1_000_000_007;
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int j = 0;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (j <= i && (map.lastKey() - map.firstKey() > k)) {
                int val = nums[j];
                int cnt = map.get(val);
                if (cnt == 1) map.remove(val);
                else map.put(val, cnt - 1);

                j++;
            }

            long ways;
            if (j > 0) {
                ways = (prefix[i] - prefix[j - 1] + MOD) % MOD;
            } else {
                ways = prefix[i] % MOD;
            }

            dp[i + 1] = ways;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }
}