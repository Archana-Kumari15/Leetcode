class Solution {
    public ListNode reverseList(ListNode head){
        if(head.next == null) return head;
        ListNode a = head.next;
        ListNode newHead = reverseList(a);
        a.next = head;
        head.next = null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode j = reverseList(slow);
        ListNode i = head;
        while(j != null){
            if(i.val != j.val) return false;
            i = i.next;
            j = j.next;
        }
        return true;
    }
}