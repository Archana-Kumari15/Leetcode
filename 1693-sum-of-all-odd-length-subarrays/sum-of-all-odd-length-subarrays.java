class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n+1];
        pre[0] = 0;
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + arr[i];
        } 
    
        int totalsum = 0;
        for(int left = 0 ; left<n ; left++){
            for(int j = 1; left+j<= n; j += 2){
               int right = left + j -1;
               int subarray = pre[right+1] - pre[left];
               totalsum += subarray;
            }
        }
        return totalsum;
    }
}