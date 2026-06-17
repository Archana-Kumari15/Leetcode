class Solution {

    long[] len;
    String s;

    public char processStr(String s, long k) {
        this.s = s;
        int n = s.length();
        len = new long[n];

        long curr = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                curr++;
            } else if (ch == '*') {
                if (curr > 0) curr--;
            } else if (ch == '#') {
                curr *= 2;
            }

            len[i] = curr;
        }

        if (k < 0 || k >= curr) return '.';

        return solve(n - 1, k);
    }

    private char solve(int idx, long k) {
        if (idx < 0) return '.';

        char ch = s.charAt(idx);
        long before = (idx == 0) ? 0 : len[idx - 1];

        if (Character.isLowerCase(ch)) {
            if (k == before) return ch;
            return solve(idx - 1, k);
        }

        if (ch == '#') {
            if (before > 0 && k >= before) {
                k -= before;
            }
            return solve(idx - 1, k);
        }

        if (ch == '%') {
            k = before - 1 - k;
            return solve(idx - 1, k);
        }
        return solve(idx - 1, k);
    }
}