class Solution {
    public int minSteps(String s, String t) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(int i = 0; i<s.length() ; i++){
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }
        int res = 0;
        for(int i = 0; i<26 ; i++){
            if(freqS[i] > freqT[i]){
                res += freqS[i] - freqT[i];
            }
        }
        return res;
    }
}