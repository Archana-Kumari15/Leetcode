class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        int idx = 1;
        int[] ans = {-1,-1};
        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;
        while(right != null){
            if(mid.val > left.val && mid.val > right.val || mid.val < left.val && mid.val < right.val){
               if(first == -1) first = idx;
               if(last != -1){
                  int dist  = idx - last;
                  minDistance = Math.min(dist,minDistance);
               }
               last = idx;
            }
            idx++;
            left = left.next;
            mid = mid.next;
            right = right.next;
        }
        if(first == last) return ans;
        int maxDistance = last - first;
        ans[0] = minDistance;
        ans[1] = maxDistance;
        return ans;
    }
}