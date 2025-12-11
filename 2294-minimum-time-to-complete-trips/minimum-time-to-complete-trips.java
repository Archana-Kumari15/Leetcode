class Solution {
    public  boolean isPossible(int[] arr,long totalTrips, long maxQ){
        long total = 0;
        int n = arr.length;
        for(int k: arr){
            total += maxQ/k;
            if(total >= totalTrips) return true;
        }

        return false;
    }
    public  long minimumTime(int[] arr, int totalTrips) {
        int n = arr.length;
        long mx = 0;
        for(int i = 0;i<n;i++){
            mx = Math.max(mx,arr[i]);
        }
        long lo = 1, hi = (long)mx *totalTrips;
        long ans = -1;
        while(lo <= hi){
            long mid = lo + (hi-lo)/2;
            if(isPossible(arr,totalTrips,mid)) {
                ans = mid;
                hi = mid - 1;
            }else lo = mid + 1;
        }
        return ans;
    }
    }
