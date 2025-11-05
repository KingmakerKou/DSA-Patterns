// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                int dupli = curr.val;
                while(curr != null && curr.val == dupli){
                    curr=curr.next;
                }
                prev.next = curr;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
    return dummy.next;
    }
}
