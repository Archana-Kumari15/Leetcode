class Solution {
    int start = 0;
    int maxlen = 0;
    public void helper(String s, int i, int j){
        while(i >= 0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        int len = j-i-1;
        if(len > maxlen){
            maxlen = len;
            start = i+1;
        }
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i<n ; i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return s.substring(start,start+maxlen);
    }
}