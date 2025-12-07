class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // if(head1==null || head2==null){
        //     return head1==null ? head2 : head1;
        // }
        // if( head1.val <= head2.val ){
        //     head1.next=mergeTwoLists(head1.next,head2);
        //     return head1;
        // }else{
        //      head2.next=mergeTwoLists(head1,head2.next);
        //     return head2;
        // }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp1 != null && temp2 != null){
          if(temp1.val <= temp2.val){
            temp.next = temp1;
            temp1 = temp1.next;
          }else{
            temp.next = temp2;
            temp2 = temp2.next;
          }
            temp = temp.next;
        }
        if(temp1 == null) temp.next = temp2;
        else temp.next = temp1;
        return dummy.next;
    }
};