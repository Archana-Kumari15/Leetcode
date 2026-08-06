class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();

        if (m > n)
            return false;

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < m; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, windowFreq))
            return true;

        for (int i = m; i < n; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i - m) - 'a']--;

            if (Arrays.equals(s1Freq, windowFreq))
                return true;
        }

        return false;
    }
}