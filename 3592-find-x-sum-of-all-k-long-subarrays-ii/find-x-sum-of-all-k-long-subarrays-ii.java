class Solution {
   public long result;
   public TreeSet<Pair> small; 
   public TreeSet<Pair> large;
   public Map<Integer, Integer> freq;
   public int x;
   public static class Pair implements Comparable<Pair> {
        int f; 
        int v; 

        Pair(int f, int v) {
            this.f = f;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.f != o.f) return Integer.compare(this.f, o.f);
            return Integer.compare(this.v, o.v);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return f == p.f && v == p.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(f, v);
        }
    }

    public Solution() {
    }

    public void insertIntoSet(Pair p) {
        if (large.size() < x || (!large.isEmpty() && large.first().compareTo   (p) < 0)) {
            result += (long)p.f * p.v;
            large.add(p);

            if (large.size() > x) {
                Pair it = large.first();
                result -= (long)it.f * it.v;
                large.remove(it);
                small.add(it);
            }
        } else {
            small.add(p);
        }
    }

    public void removeFromSet(Pair p) {
        if (!large.isEmpty() && p.compareTo(large.first()) >= 0) {
            if (large.remove(p)) {
                result -= (long)p.f * p.v;
                if (!small.isEmpty()) {
                    Pair it = small.last();
                    small.remove(it);
                    large.add(it);
                    result += (long)it.f * it.v;
                }
            }
        } else {
            small.remove(p);
        }
    }

    public void insert(int num) {
        int cur = freq.getOrDefault(num, 0);
        if (cur > 0) { 
            removeFromSet(new Pair(cur, num));
        }
        cur++;
        freq.put(num, cur);
        insertIntoSet(new Pair(cur, num));
    }

    public void remove(int num) {
        int cur = freq.getOrDefault(num, 0);
        if (cur == 0) return; 
        removeFromSet(new Pair(cur, num));
        cur--;
        if (cur == 0) {
            freq.remove(num);
        } else {
            freq.put(num, cur);
            insertIntoSet(new Pair(cur, num));
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        this.result = 0L;
        this.small = new TreeSet<>();
        this.large = new TreeSet<>();
        this.freq = new HashMap<>();
        this.x = x;

        List<Long> out = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            insert(nums[i]);
            if (i >= k) {
                remove(nums[i - k]);
            }
            if (i >= k - 1) {
                out.add(result);
            }
        }

        long[] ans = new long[out.size()];
        for (int i = 0; i < out.size(); ++i) ans[i] = out.get(i);
        return ans;
    }
}