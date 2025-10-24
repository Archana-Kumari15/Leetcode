class Solution {
    public int nextBeautifulNumber(int n) {
        TreeSet<Integer> results = new TreeSet<>();
        for (int mask = 1; mask < (1 << 9); mask++) {
            List<Character> multiset = new ArrayList<>();
            int totalLen = 0;
            for (int i = 0; i < 9; i++) {
                if (((mask >> i) & 1) == 1) {
                    int d = i + 1; 
                    totalLen += d;
                    for (int k = 0; k < d; k++) multiset.add((char)('0' + d));
                }
            }
            if (totalLen == 0 || totalLen > 7) continue;
            char[] arr = new char[multiset.size()];
            for (int i = 0; i < multiset.size(); i++) arr[i] = multiset.get(i);
            Arrays.sort(arr);
            do {
                if (arr[0] == '0') continue;
                int val = 0;
                for (char c : arr) {
                    val = val * 10 + (c - '0');
                }
                results.add(val);
            } while (nextPermutation(arr));
        }
        for (int v : results) {
            if (v > n) return v;
        }
        throw new IllegalArgumentException("No numerically-balanced number found for given n.");
    }
    public boolean nextPermutation(char[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;
        int j = a.length - 1;
        while (a[j] <= a[i]) j--;
        swap(a, i, j);
        reverse(a, i + 1, a.length - 1);
        return true;
    }

    public void swap(char[] a, int i, int j) {
        char t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public void reverse(char[] a, int l, int r) {
        while (l < r) swap(a, l++, r--);
    }
 }
