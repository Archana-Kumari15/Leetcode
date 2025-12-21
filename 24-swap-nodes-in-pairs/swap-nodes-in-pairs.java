class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null && prev.next.next != null){
            ListNode a = prev.next;
            ListNode b = a.next;

            a.next  = b.next;
            b.next = a;
            prev.next = b;

            prev = a;
        }
        return dummy.next;
    }
}