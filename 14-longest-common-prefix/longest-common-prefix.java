class Solution {
    public String longestCommonPrefix(String[] s) {
        int n = s.length;
        if(n == 0) return "";
        String ans = s[0];
        for(int i = 0; i<ans.length(); i++){
            char ch = ans.charAt(i);
            for(int j = 1; j<n ; j++){
                if(i >= s[j].length() || s[j].charAt(i) != ch){
                    return ans.substring(0,i);
                }
            }
        }
        return ans;
    }
}