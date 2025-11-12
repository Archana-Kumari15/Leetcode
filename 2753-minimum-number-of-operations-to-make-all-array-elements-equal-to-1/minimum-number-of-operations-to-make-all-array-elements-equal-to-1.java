class Solution {
    public int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        a = Math.abs(a); b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public  int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int x : nums) if (x == 1) ones++;
        if (ones > 0) return n - ones;
        int g = 0;
        for (int x : nums) g = gcd(g, x);
        if (g > 1) return -1;
        int bestL = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = i; j < n; ++j) {
                cur = gcd(cur, nums[j]);
                if (cur == 1) {
                    bestL = Math.min(bestL, j - i + 1);
                    break; 
                }
            }
        }
        return (bestL - 1) + (n - 1);
     }
}