class Solution {
    public int searchInsert(int[] arr, int target) {
         int n = arr.length;
        int lo = 0, hi = n - 1;
        int lb = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) {
                // lb=Math.min(lb,mid);
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return lo;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // int n = arr.length;
        // int lo=0, hi=n-1;
        // while(lo <= hi){
        //     int mid = lo + (hi-lo)/2;
        //     if(arr[mid] == target) return mid;
        //     else if(arr[mid] > target) hi = mid-1;
        //     else lo = mid+1;
        // }
        // return lo;
    }
}