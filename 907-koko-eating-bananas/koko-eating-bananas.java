class Solution {
    // public static boolean isPossible(int k,int h,int[] piles){
    //     int pile = 0;
    //     for(int i =0;i<arr.length;i++){
    //         if(arr[i] % k == 0) pile += arr[i]/k;
    //         else pile += arr[i]/k +1;
    //     }
    //     if(k > h) return false;
    //     return true;
    // }
      public boolean canEatAll(int[] piles, int h, int k){

        int pile = 0;
        for(int p : piles){
            pile += Math.ceil((double)p/k);
            // else pile += piles[i]/k +1;
        }
        if(pile > h) return false;
        return true;}
    //     int hours = 0;
    //     for(int p : piles){
    //         hours += Math.ceil((double)p/k);
    //         if(hours > h) return false;
    //     }
    //     return hours <=h;
    // }
    public int minEatingSpeed(int[] piles, int h) {
         int n = piles.length;
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mx = Math.max(mx,piles[i]);
        }
        int lo = 1 , hi = mx;
        int ans = 0;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(canEatAll(piles,h,mid)){
                ans = mid;
                hi = mid-1;
            }else lo = mid+1;
        }
        return ans;






















    //     int lo = 1, hi = 0;
    //     for(int p : piles){
    //         hi = Math.max(hi,p);
    //     }
    //     while(lo < hi){
    //         int mid = lo + (hi - lo)/2;
    //         if(canEatAll(piles,h,mid)){
    //             hi = mid;
    //         }else{
    //             lo = mid + 1;
    //         }
    //     }
    //     return lo;
    }
}