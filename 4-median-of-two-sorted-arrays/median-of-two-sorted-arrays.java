class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
       int m = a.length;
       int n = b.length;
       double[] c = new double[m+n];
       int i = 0, j = 0 , k = 0;
       while(i<m && j<n){
        if(a[i] <= b[j]) c[k++] = a[i++];
        else c[k++] = b[j++];
       }
       while(i < m) c[k++] = a[i++];
       while(j < n) c[k++] = b[j++];
       if((m+n) % 2 == 0)
          return (c[((m+n)-1)/2] + c[((m+n)+1)/2]) / 2;
        else 
           return c[(m+n)/2];
    }
}