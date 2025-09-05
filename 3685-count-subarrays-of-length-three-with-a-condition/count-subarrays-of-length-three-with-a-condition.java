class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n-2; i++){
            if(2*(arr[i] + arr[i+2]) == arr[i+1]) count++;
        }
        return count;
    }
}