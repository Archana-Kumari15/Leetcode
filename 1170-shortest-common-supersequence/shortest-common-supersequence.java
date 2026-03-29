class Solution {
    public String LCS(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<=m ; i++){
            for(int j = 1; j<=n ; j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        StringBuilder str = new StringBuilder("");
        int i = m, j = n;
        while(i>0 && j>0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                str.append(a.charAt(i-1));
                i--; j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }
        str.reverse();
        return str.toString();
    }
    public String shortestCommonSupersequence(String a, String b) {
        String lcs = LCS(a,b);
        int i = 0, j = 0, k = 0;
        String str = "";
        while(k < lcs.length()){
            while(a.charAt(i) != lcs.charAt(k)){
                str += a.charAt(i);
                i++;
            }
            while(b.charAt(j) != lcs.charAt(k)){
                str += b.charAt(j);
                j++;
            }
                str += lcs.charAt(k);
                i++; j++; k++;
        }
        while(j < b.length()) str += b.charAt(j++);
        while(i < a.length()) str += a.charAt(i++);
        return str;
    }
}