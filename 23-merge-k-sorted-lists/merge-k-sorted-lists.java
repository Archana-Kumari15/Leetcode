class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        int dist = 1;
        while(dist < lists.length){
            for(int p = 0; p + dist < lists.length; p = p + 2*dist){
                lists[p] = mergeTwoLists(lists[p],lists[p+dist]);
            }
            dist *= 2;
        }
        return lists[0];
    }
}