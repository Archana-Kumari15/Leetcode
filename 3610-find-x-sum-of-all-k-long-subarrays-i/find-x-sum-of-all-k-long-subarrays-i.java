class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
       int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] ans = new int[n - k + 1];

        final int MAXV = 50; 
        int[] freq = new int[MAXV + 1];
        for (int i = 0; i < k; i++) freq[nums[i]]++;

        ans[0] = computeXSumFromFreq(freq, k, x);
        for (int start = 1; start <= n - k; start++) {
            int left = nums[start - 1];
            int right = nums[start + k - 1];

            freq[left]--;
            freq[right]++;
            ans[start] = computeXSumFromFreq(freq, k, x);
        }

        return ans;
    }
    public int computeXSumFromFreq(int[] freq, int k, int x) {
        List<int[]> list = new ArrayList<>();
        for (int val = 1; val <= 50; val++) {
            if (freq[val] > 0) list.add(new int[]{freq[val], val});
        }
        list.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
            return Integer.compare(b[1], a[1]);
        });

        int sum = 0;
        int limit = Math.min(x, list.size());
        for (int i = 0; i < limit; i++) {
            sum += list.get(i)[0] * list.get(i)[1];
        }
        return sum;
    }
}