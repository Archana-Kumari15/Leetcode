class Solution {
    public void nextPermutation(int[] arr) {
       int n = arr.length;
       int bp = -1;
       for(int i=n-2; i>=0 ;i--){
         if(arr[i]<arr[i+1]){
            bp=i;
            break;
         }
       }
       if(bp==-1){
        reverse(arr,0,n-1);
        return;
       }
       for(int j=n-1; j>=0 ;j--){
          if(arr[j]>arr[bp]){
            swap(arr,j,bp);
            break;
          }
       }
       reverse(arr,bp+1,n-1);
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        } 
    }
}