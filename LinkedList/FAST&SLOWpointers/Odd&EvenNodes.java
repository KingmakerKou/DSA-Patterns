/**
 * LeetCode Problem: 328. Odd Even Linked List
 *
 * Problem:
 * Given the head of a singly linked list, group all the nodes with odd indices together
 * followed by the nodes with even indices. Return the reordered list.
 *
 * Approach:
 * - Maintain two pointers: `odd` (starting at head) and `even` (starting at head.next).
 * - Keep the head of the even list in `evenHead`.
 * - Advance odd by two and even by two until no more nodes.
 * - Attach evenHead after the last odd node.
 *
 * Time Complexity: O(n)  -> Single pass through the list.
 * Space Complexity: O(1) -> Only constant extra space used.
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head.next;
        ListNode temp = head.next;
        while(slow!=null && slow.next!=null){
            fast.next = fast.next.next;
            fast=fast.next;
            slow.next = slow.next.next;
            slow=slow.next;
        }
        fast.next=temp;  
        
    return head;   
    }
}
