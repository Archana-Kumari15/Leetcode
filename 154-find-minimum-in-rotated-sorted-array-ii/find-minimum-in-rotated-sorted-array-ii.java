class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int lo = 0, hi = n - 1;
      
        while (lo < hi) {
            int mid = (lo + hi) / 2;
           
           if(arr[mid] == arr[hi]){
               hi--;
           }
          // else if(arr[lo] == arr[hi]) return arr[lo];
           else if(arr[mid] < arr[hi])  hi=mid;
           else if(arr[mid] > arr[hi])  lo = mid+1;
        }
        return arr[lo];
    }
}