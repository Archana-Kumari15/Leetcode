class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n ; i++){
            while(!st.isEmpty() && height[i] <= height[st.peek()]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1; i >= 0 ; i--){
            while(!st.isEmpty() && height[i] <= height[st.peek()]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int max = -1;
        for(int i = 0; i<n ; i++){
            int width = nse[i] - pse[i] -1;
            int area = height[i] * width;
            max = Math.max(max,area);
        }
        return max;
    }
}