class Solution {
    public int minimumOneBitOperations(int n) {
        return helper(n);
    }
    
    public int helper(int n) {
        if (n == 0) return 0;
        int k = 31 - Integer.numberOfLeadingZeros(n);
        int powK = 1 << k;                    
        int allOnes = (1 << (k + 1)) - 1;     
        return allOnes - helper(n - powK);
    }  
}
