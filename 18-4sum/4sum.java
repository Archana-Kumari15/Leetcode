class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n= arr.length;
         List<List<Integer>> ans = new ArrayList<>();
         Arrays.sort(arr);
         for(int i=0;i<n;i++){
            if( i!=0 && arr[i]==arr[i-1]) continue;

           for(int j=i+1;j<n;j++){
            if( j!=i+1 && arr[j]==arr[j-1]) continue; 
             int k=j+1;
             int l=n-1;
             while(k<l){
             long sum = (long)arr[i]+arr[j]+arr[k]+arr[l];
                if(sum<target){
                    k++;
                }else if(sum>target){
                    l--;
                }else{
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                    ans.add(temp);
                    k++;
                    l--;
                while (k < l && arr[k] == arr[k - 1]) k++;
                while (k < l && l<n-1 && arr[l] == arr[l + 1]) l--;
                }
             }
           } 
        }
        return ans;
    }
}