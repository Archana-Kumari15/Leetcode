class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int best = Integer.MIN_VALUE;
        for (int r = 0; r < k; r++) {
            int last = r + ((n - 1 - r) / k) * k;
             int suffixSum = 0;
            for (int i = last; i >= r; i -= k) {
                suffixSum += energy[i];
                if (suffixSum > best) best = suffixSum;
            }
        }
        return best;
    }
}