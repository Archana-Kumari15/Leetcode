class Solution {
    int start = 0;
    int maxlen = 0;
    public void expandfromCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int len = right - left - 1;
        if(len > maxlen){
            maxlen = len;
            start = left+1;
        }
    }
    public String longestPalindrome(String s) {
        if(s.isEmpty() || s.length() < 2) return s;
        for(int i = 0; i<s.length() ; i++){
            expandfromCenter(s,i,i);
            expandfromCenter(s,i,i+1);
        }
        return s.substring(start,start+maxlen);
    }
}