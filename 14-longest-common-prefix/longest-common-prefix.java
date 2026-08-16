class Solution {
    public String longestCommonPrefix(String[] s) {
        int n = s.length;
        if(n == 0) return "";
        String ans = s[0];
        for(int i = 1; i<n; i++){
            while(!s[i].startsWith(ans)){
                ans = ans.substring(0,ans.length()-1);
                if(ans.length() == 0) return ""; 
            }
        }
        return ans;
    }
}