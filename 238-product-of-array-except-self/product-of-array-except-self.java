class Solution {
    public int[] productExceptSelf(int[] arr) {
       int n = arr.length;
       int[] pre = new int[n];
      // int[] suff = new int[n];
       pre[0] = 1;
       for(int i = 1; i<n ; i++){
        pre[i] = pre[i-1] * arr[i-1];
       }
      // suff[n-1] = 1;
      int suff = 1;
       for(int i = n-2 ; i>=0 ; i--){
        suff *= arr[i+1];
        pre[i] *= suff;
       }
    //    for(int i = 0; i< n ; i++){
    //     arr[i] = pre[i] * suff[i];
    //    }
    //    return arr;

    return pre;
    }
}