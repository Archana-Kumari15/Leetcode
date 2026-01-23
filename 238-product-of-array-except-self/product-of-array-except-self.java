class Solution {
    public int[] productExceptSelf(int[] arr) {
       int n = arr.length;
       int[] prefix = new int[n];
       int[] suffix = new int[n];
       prefix[0] = 1;
       for(int i = 1; i<=n-1 ; i++){
           prefix[i] = arr[i-1] * prefix[i-1]; 
       }
       suffix[n-1] = 1;
       for(int i = n-2; i>=0 ; i--){
           suffix[i] = arr[i+1] * suffix[i+1]; 
       }
       for(int k = 0;k<n;k++){
         arr[k] = prefix[k]*suffix[k];
       }
       return arr;
    }
}