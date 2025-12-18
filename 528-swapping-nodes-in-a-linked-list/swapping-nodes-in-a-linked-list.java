class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode nodeA = head;
        for(int i = 1; i <= k-1; i++){
            nodeA = nodeA.next;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1; i <= k ; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode nodeB = slow;
        int temp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = temp;
        return head;
    }
}