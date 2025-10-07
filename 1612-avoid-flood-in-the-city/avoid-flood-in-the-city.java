class Solution {
    public int[] avoidFlood(int[] rains) {
          int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1); 
        Map<Integer, Integer> last = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();  
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                ans[i] = -1; 
                if (last.containsKey(lake)) {
                    int prevDay = last.get(lake);
                    Integer dryDay = zeros.higher(prevDay);
                    if (dryDay == null) {
                        return new int[0];
                    }
                    ans[dryDay] = lake;
                    zeros.remove(dryDay);
                }
                last.put(lake, i);
            } else {
                zeros.add(i);
            }
        }
        return ans;
    }
}