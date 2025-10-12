class Solution {
    static final int MOD = 1_000_000_007;
    static long modPow(long a, int e) {
        long r = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return r;
    }
    static long inv(long x) {
        return modPow(x, MOD - 2);
    }
    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[m] = inv(fact[m]);
        for (int i = m - 1; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;

        long[][] pow = new long[n][m + 1];
        for (int j = 0; j < n; j++) {
            pow[j][0] = 1;
            long base = nums[j] % MOD;
            for (int t = 1; t <= m; t++) pow[j][t] = (pow[j][t - 1] * base) % MOD;
        }
        int M = m;
        long[][][] dp = new long[M + 1][M + 1][M + 1];
        dp[0][0][0] = 1;
        for (int j = 0; j < n; j++) {
            long[][][] next = new long[M + 1][M + 1][M + 1];
            for (int carry = 0; carry <= M; carry++) {
                for (int ones = 0; ones <= M; ones++) {
                    for (int used = 0; used <= M; used++) {
                        long cur = dp[carry][ones][used];
                        if (cur == 0) continue;
                        int maxT = M - used;
                        for (int t = 0; t <= maxT; t++) {
                            int total = carry + t;
                            int bit = total & 1;
                            int carry2 = total >> 1;
                            int ones2 = ones + bit;
                            int used2 = used + t;
                            if (ones2 > M || carry2 > M) continue; 
                            long mult = (pow[j][t] * invFact[t]) % MOD;
                            long add = (cur * mult) % MOD;
                            next[carry2][ones2][used2] += add;
                            if (next[carry2][ones2][used2] >= MOD) next[carry2][ones2]
                            [used2] -= MOD;
                        }
                    }
                }
            }
            dp = next;
        }
        long innerSum = 0;
        for (int carry = 0; carry <= M; carry++) {
            for (int ones = 0; ones <= M; ones++) {
                long val = dp[carry][ones][m]; 
                if (val == 0) continue;
                int extraOnes = Integer.bitCount(carry);
                int totalOnes = ones + extraOnes;
                if (totalOnes == k) {
                    innerSum += val;
                    if (innerSum >= MOD) innerSum -= MOD;
                }
            }
        }
        long ans = (innerSum * fact[m]) % MOD;
        return (int) ans;
    }
}