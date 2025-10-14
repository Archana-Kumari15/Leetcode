class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        // int index=-1;
        // for(int i=0;i<n;i++){
        //     if(arr[i]==target){
        //         index=i;
        //         } 
        // }
        // return index;

        int lo = 0, hi = n-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == target) return mid;
            else if( arr[mid] <= arr[hi]){
                if(arr[mid] <= target && target <= arr[hi]) lo = mid+1;
                else hi = mid - 1;
            }
            else{
                if(arr[lo] <= target && target <= arr[mid]) hi = hi - 1;
                else lo = lo + 1;
            }
        }
        return -1;
    }
}