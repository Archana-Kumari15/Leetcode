class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int target) {
        int n=arr.length;
        if(target==0) return 0;
        int count = 0;
        int i=0;
        int pro=1;
        
        for(int j=0;j<n;j++){
            pro*=arr[j];
            while(i<=j && pro >= target){
                  pro/=arr[i++];
            }
            count += j-i+1;
        }
     
        return count;
    }
}