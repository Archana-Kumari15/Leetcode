class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int noOfZeros=0, noOfOnes=0;  
        for(int i=0;i<n;i++){
            if(arr[i]==0)  noOfZeros++;
            if(arr[i]==1)  noOfOnes++;
        } 

        for(int i=0;i<n;i++){
            if(i < noOfZeros)  arr[i]=0;
            else if(i < noOfZeros + noOfOnes) arr[i]=1;
            else arr[i]=2;
        }

    }
}