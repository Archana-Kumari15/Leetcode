class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int i = 0, j = 0, sum = 0;
        int minl = Integer.MAX_VALUE;
        while(j < n){
            sum += arr[j];
            while(sum >= target){
                minl = Math.min(minl,j-i+1);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return minl == Integer.MAX_VALUE ? 0 : minl;
    }
}