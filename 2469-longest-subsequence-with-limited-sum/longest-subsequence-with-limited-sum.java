class Solution {
    public int[] answerQueries(int[] arr, int[] que) {
        Arrays.sort(arr);
        int n = arr.length , m = que.length;
        for(int i = 1; i<n ; i++){
            arr[i] += arr[i-1];
        }
        int[] ans = new int[m];
        for(int i = 0; i<m ; i++){
            int lo = 0, hi = n-1;
            while(lo <= hi){
                int mid = lo + (hi-lo)/2;
                if(arr[mid] > que[i]) hi = mid-1;
                else{
                    ans[i] = Math.max(ans[i],mid+1);
                    lo = mid+1;
                }
            }
        }
        return ans;
    }
}