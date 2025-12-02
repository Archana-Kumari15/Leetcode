class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1_000_000_007L;
        final long INV2 = 500_000_004L;  
        Map<Integer, Long> freq = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            freq.put(y, freq.getOrDefault(y, 0L) + 1);
        }

        long sumA = 0; 
        long sumA2 = 0;  

        for (long cnt : freq.values()) {
            if (cnt >= 2) {
                long a = cnt * (cnt - 1) / 2;  
                a %= MOD;

                sumA = (sumA + a) % MOD;
                long a2 = (a * a) % MOD;
                sumA2 = (sumA2 + a2) % MOD;
            }
        }
        if (sumA == 0) {
            return 0;
        }

        long ans = (sumA * sumA) % MOD;        
        ans = (ans - sumA2 + MOD) % MOD;   
        ans = (ans * INV2) % MOD;              

        return (int) ans;

    }
}