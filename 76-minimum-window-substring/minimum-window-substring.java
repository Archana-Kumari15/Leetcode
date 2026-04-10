class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int n = s.length();
        int requiredcount = t.length();
       Map<Character,Integer> mp = new HashMap<>();
       for(char ch : t.toCharArray()){
         mp.put(ch, mp.getOrDefault(ch, 0) + 1);  
       }
       int i = 0, j =0;
        int startidx = 0;
        int minWindowSize = Integer.MAX_VALUE;

        while(j < n){
            char ch = s.charAt(j);
           if(mp.getOrDefault(ch, 0) > 0){
                requiredcount--;
            }
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);
            while(requiredcount == 0){
                int currWindowSize = j-i+1;
                if(minWindowSize > currWindowSize){
                    minWindowSize = currWindowSize;
                    startidx = i;
                }
               char leftChar = s.charAt(i);
                mp.put(leftChar, mp.getOrDefault(leftChar, 0) + 1);

                if(mp.get(leftChar) > 0){
                    requiredcount++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(startidx, startidx + minWindowSize);
    }
}