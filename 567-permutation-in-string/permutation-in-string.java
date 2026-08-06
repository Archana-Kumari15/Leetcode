class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        int[] s1freq = new int[26];
        int[] windowfreq = new int[26];
        for(int i = 0; i<n ; i++){
            s1freq[s1.charAt(i) - 'a']++;
            windowfreq[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1freq,windowfreq)){
            return true;
        }
        for(int i = n; i<m ; i++){
            windowfreq[s2.charAt(i) - 'a']++;
            windowfreq[s2.charAt(i-n) - 'a']--;
            if(Arrays.equals(s1freq,windowfreq)){
                return true;
            }
        }
        return false;
    }
}