class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode temp = head;
        // int len = 0;
        // while(temp!=null){
        //     temp = temp.next;
        //     len++;
        // }
        // if(len==n) return head.next;
        // temp = head;
        // for(int i = 1; i<=len-n-1;i++){
        //     temp = temp.next;
        // }
        // temp.next = temp.next.next;
        // return head;

        ListNode slow = head;
        ListNode fast = head;
        for(int i=1; i<=n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}