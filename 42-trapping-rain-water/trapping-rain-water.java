class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i<n ; i++){
            while(!st.isEmpty() && height[i] > height[st.peek()]){
                int mid = st.pop();
                if(st.isEmpty()) break;
                int left = st.peek();
                int distance = i - left -1;
                int length = Math.min(height[left],height[i]) - height[mid];
                water += distance * length;
            }
            st.push(i);
        }
        return water;
    }
}