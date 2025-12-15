class Solution {
    public ListNode middle(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode a = head.next;
        ListNode nh = reverse(a);
        a.next = head;
        head.next = null;
        return nh;
    }
    public void reorderList(ListNode head) {
        ListNode leftMiddle = middle(head);
        ListNode h2 = leftMiddle.next;
        leftMiddle.next = null;
        h2 = reverse(h2);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head != null && h2 != null){
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;
        }
        if(head == null) temp.next = h2;
        if(h2 == null) temp.next = head;
        head = dummy.next;
    }
}