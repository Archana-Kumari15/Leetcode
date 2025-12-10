class Solution {
      public boolean canEatAll(int[] piles, int h, int k){
        int pile = 0;
        for(int p : piles){
            pile += Math.ceil((double)p/k);
        }
        if(pile > h) return false;
        return true;
      }
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
    }
}