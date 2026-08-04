class Solution {
    public int sumSubarrayMins(int[] nums) {
        int n = nums.length;
        long MOD = 1000000007;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n ; i++){
            while(!st.isEmpty() && nums[i] < nums[st.peek()]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        for(int i = n-1; i>=0 ; i--){
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long minsum = 0;
        for(int i = 0; i<n ; i++){
            long left = (i-pse[i]);
            long right = (nse[i] - i);
            minsum = (minsum + (nums[i] * left % MOD) * right ) % MOD;
        }
        return (int)minsum;
    }
}