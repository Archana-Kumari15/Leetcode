class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.add(s);
        seen.add(s);
        String ans = s;

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(ans) < 0) ans = cur;
            String added = addToOdd(cur, a);
            if (!seen.contains(added)) {
                seen.add(added);
                q.add(added);
            }
            String rotated = rotateRight(cur, b);
            if (!seen.contains(rotated)) {
                seen.add(rotated);
                q.add(rotated);
            }
        }

        return ans;
    }
    public String addToOdd(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int digit = arr[i] - '0';
            digit = (digit + a) % 10;
            arr[i] = (char) ('0' + digit);
        }
        return new String(arr);
    }
    private String rotateRight(String s, int b) {
        int n = s.length();
        b = b % n;
        if (b == 0) return s;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
