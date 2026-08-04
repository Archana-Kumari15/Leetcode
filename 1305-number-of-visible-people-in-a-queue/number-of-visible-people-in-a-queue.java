class Solution {
    public int[] canSeePersonsCount(int[] height) {
        int n = height.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            int visible = 0;
           while(!st.isEmpty() && height[i] > st.peek()){
            st.pop();
            visible++;
            
           }
           if(!st.isEmpty()) visible++;
          ans[i] = visible;
           st.push(height[i]);
        }
        return ans;
    }
}