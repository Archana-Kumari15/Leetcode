class Solution {
    int count = 0;
    public void expand(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
    }
    public int countSubstrings(String s) {
        for(int i = 0 ;i<s.length() ; i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return count;
    }
}