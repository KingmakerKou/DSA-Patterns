class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode point = dummy;
        point.next = head;

        while(point.next != null && point.next.next != null){
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            swap1.next = swap1.next.next;
            swap2.next = swap1;

            point.next = swap2;
            point = swap1;
        }
    return dummy.next;
    }
}
//time comp : O(N) 
//space comp : O(1) --> just using extra pointers so not much memory is used in this

// classic recursion problem but we solved it using without recursion just by changing pointers
