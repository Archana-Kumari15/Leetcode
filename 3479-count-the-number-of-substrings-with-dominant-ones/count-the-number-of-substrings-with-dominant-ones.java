class Solution {
 public int numberOfSubstrings(String s) {
    int len = s.length();

    int[] pref0 = new int[len];
    int[] pref1 = new int[len];

    pref0[0] = (s.charAt(0) == '0') ? 1 : 0;
    pref1[0] = (s.charAt(0) == '1') ? 1 : 0;

    for (int i = 1; i < len; i++) {
        pref0[i] = pref0[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        pref1[i] = pref1[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
    }

    int count = 0;

    for (int i = 0; i < len; i++) {
        for (int j = i; j < len; ) {

            int zeros = pref0[j] - (i > 0 ? pref0[i - 1] : 0);
            int ones  = pref1[j] - (i > 0 ? pref1[i - 1] : 0);

            int skip = zeros * zeros - ones;

            if (ones >= zeros * zeros) {
                int t = (int)Math.sqrt(ones) - zeros;
                skip = Math.max(t, 1);

                count += Math.min(skip, len - j);
            }

            j += skip;
        }
    }

    return count;
}


}