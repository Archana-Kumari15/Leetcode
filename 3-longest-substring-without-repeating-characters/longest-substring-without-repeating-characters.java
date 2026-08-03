class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int maxlen = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int j = 0; j<n ; j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                i = Math.max(i, map.get(ch) + 1);
            }
           map.put(ch,j);
          maxlen = Math.max(maxlen, j-i+1);
        }
         return maxlen;
    }
}