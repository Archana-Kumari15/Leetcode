class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] psCurr = new long[n];
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += 1L * skill[i] * mana[0];
            psCurr[i] = sum;
        }

        long start = 0L; 
        for (int j = 0; j + 1 < m; ++j) {
            long[] psNext = new long[n];
            sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += 1L * skill[i] * mana[j + 1];
                psNext[i] = sum;
            }
            long delta = Long.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                long prev = (i == 0) ? 0L : psNext[i - 1];
                long val = psCurr[i] - prev;
                if (val > delta) delta = val;
            }

            start += delta;   
            psCurr = psNext;    
        }
        return start + psCurr[n - 1];
    }
}