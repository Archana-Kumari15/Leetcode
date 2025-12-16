class Solution {
    public int[] runningSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i = 1; i<n ; i++){
            arr[i] = arr[i-1] + arr[i];
        }
        return arr;
    }
}