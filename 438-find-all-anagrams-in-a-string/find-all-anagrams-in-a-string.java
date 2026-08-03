class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        if(m > n) return ans;
        int[] pat = new int[26];
        int[] window = new int[26];
        for(int i = 0; i<m ; i++){
            pat[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pat,window)){
             ans.add(0);
        }
        for(int i = m ; i<n ; i++){
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i-m) - 'a']--;
            if(Arrays.equals(pat,window)){
                ans.add(i-m+1);
            }
        }
        return ans;
    }
}