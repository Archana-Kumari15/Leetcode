class Solution {
    public int maxOperations(String s) {
        
        int count = 0;
        int prefix = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i == n - 1 || s.charAt(i + 1) == '1') {
                    count += prefix;
                }
            } else {
                prefix++;
            }
        }
        
        return count;
    }
}
