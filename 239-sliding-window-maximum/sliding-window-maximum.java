class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deq = new ArrayDeque<>();
        int[] result = new int[n-k+1];
        for(int i = 0; i<n ; i++){
            while(!deq.isEmpty() && deq.peekFirst() <= i - k){
                deq.pollFirst();
            }
            while(!deq.isEmpty() && nums[i] >= nums[deq.peekLast()]){
                deq.pollLast();
            }
            deq.offerLast(i);
            if(i >= k-1){
                result[i - k + 1] = nums[deq.peekFirst()];
            }
        }
        return result;
    }
}