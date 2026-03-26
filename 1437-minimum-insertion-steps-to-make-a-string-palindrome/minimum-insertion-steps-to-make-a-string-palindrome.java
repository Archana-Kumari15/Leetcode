class Solution {
    public int lcs(int i, int j , String a, String b,int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] =  1 + lcs(i-1,j-1,a,b,dp);
        else{
            return dp[i][j] =  Math.max(lcs(i-1,j,a,b,dp), lcs(i,j-1,a,b,dp));
        }
    }
    public int lcs2(String a, String b){
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        int m = sa.length();
        int n = sb.length();
        int[][] dp = new int[m][n];
        for(int i = 0 ; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return lcs(m-1,n-1,a,b,dp);
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        return s;  
        }
    public int longestPalindromeSubseq(String s) {
        return lcs2(s,reverse(s));
    }
    public int minInsertions(String s) {
        int n = s.length();
        return n - longestPalindromeSubseq(s);
    }
}