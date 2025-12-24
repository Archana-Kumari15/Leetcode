class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforeA = list1;
        for(int i = 0; i<a-1 ; i++){
            beforeA = beforeA.next;
        }
        ListNode afterB = beforeA;
        for(int i = 0 ; i<= b-a+1 ; i++){
            afterB = afterB.next;
        }
        beforeA.next = list2;
        ListNode last = list2;
        while(last.next != null){
            last = last.next;
        }
       
        last.next = afterB;
        return list1;
    }
}