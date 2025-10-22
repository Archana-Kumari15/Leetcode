import java.util.*;

public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        HashMap<Long, Integer> mp = new HashMap<>();
        HashMap<Long, Integer> freq = new HashMap<>();
        TreeSet<Long> points = new TreeSet<>();

        for (int val : nums) {
            long v = val;
            freq.put(v, freq.getOrDefault(v, 0) + 1);

            long start = v - (long) k;
            long endPlusOne = v + (long) k + 1L;

            mp.put(start, mp.getOrDefault(start, 0) + 1);
            mp.put(endPlusOne, mp.getOrDefault(endPlusOne, 0) - 1);

            points.add(v);
            points.add(start);
            points.add(endPlusOne);
        }

        int ans = 1;
        long sum = 0;

        for (Long curr : points) {
            sum += mp.getOrDefault(curr, 0);
            int f = freq.getOrDefault(curr, 0);
            long others = sum - f;
            if (others < 0) others = 0; 

            int extra = (int) Math.min(others, (long) numOperations);
            ans = Math.max(ans, f + extra);
        }

        return ans;
    }
}
