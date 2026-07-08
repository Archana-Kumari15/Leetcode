class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxleft = height[i];
        int maxright = height[j];
        // int maxstoredWater = 0;
        int water = 0;
        while(i < j){
            if(maxleft <= maxright){
                i++;
            maxleft = Math.max(maxleft,height[i]);
            water += maxleft - height[i];
            }
         else if(maxleft > maxright){
                j--;
            maxright = Math.max(maxright,height[j]);
            water += maxright - height[j];
            }
        }
        
        return water;
    }
}