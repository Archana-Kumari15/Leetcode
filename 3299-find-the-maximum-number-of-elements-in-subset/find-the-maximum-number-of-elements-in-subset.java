
class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }
        int ans = 1;
        for (long x : freq.keySet()) {
            if (x == 1) {
                int count = freq.get(1L);
                ans = Math.max(ans, count % 2 == 0 ? count - 1 : count);
                continue;
            }
            long cur = x;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;

                if (cur > 1000000000L / cur)
                    break;

                cur = cur * cur;
            }

            if (freq.getOrDefault(cur, 0) == 1)
                len++;
            else
                len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}