class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        int maxleft = arr[i];
        int maxright = arr[j];
        int water = 0;
        while(i < j){
            if(maxleft <= maxright){
                i++;
                maxleft = Math.max(maxleft,arr[i]);
                water += maxleft - arr[i];
            }else if(maxright < maxleft){
                j--;
                maxright = Math.max(maxright,arr[j]);
                water += maxright - arr[j];
            }
        }
        return water;
    }
}