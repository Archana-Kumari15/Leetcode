class Solution {
    boolean allZero(int[] counter){
        for(int i : counter){
            if(i != 0) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String txt, String pat) {
       int n = txt.length();
       int[] counter = new int[26];
       for(int i = 0; i<pat.length() ; i++){
           char ch = pat.charAt(i);
           counter[ch - 'a']++;
       }
       int i = 0, j = 0;
       int res = 0;
       int k = pat.length();
       List<Integer> ans = new ArrayList<>();
       while(j < n){
           counter[txt.charAt(j) - 'a']--;
           if(j-i+1 == k){
               if(allZero(counter)){
                   ans.add(i);
               }
               counter[txt.charAt(i) - 'a']++;
               i++;
           }
           j++;
       }
        return ans;
    }
}

 
 
      