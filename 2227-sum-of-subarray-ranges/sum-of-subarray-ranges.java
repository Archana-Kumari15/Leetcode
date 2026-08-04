class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        int[] nge = new int[n];
        int[] pge = new int[n];
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
        st.clear();

         for(int i = 0; i<n ; i++){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        for(int i = n-1; i>=0 ; i--){
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long ans = 0;
        long maxSum = 0;
        long minSum = 0;
        for(int i = 0; i<n ; i++){
            maxSum += (long)nums[i] * (i - pge[i]) * (nge[i] - i);
            minSum += (long)nums[i] * (i-pse[i]) * (nse[i]-i);
            ans = maxSum - minSum;
        }
        return ans;
    }
}