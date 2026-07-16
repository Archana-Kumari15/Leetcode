class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int maxarea = 0;
        while(i<j){
            int length = j-i;
            int width = Math.min(height[i],height[j]);
            int area = length*width;
            maxarea = Math.max(maxarea,area);
            if(height[i] > height[j]) j--;
            else i++;
        }
    return maxarea;
    }
}