/**
 * LeetCode Problem: 21. Merge Two Sorted Lists
 * 
 * Problem:
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Approach:
 * - Use a dummy node to simplify list construction.
 * - Traverse both lists:
 *   → Compare current nodes of l1 and l2.
 *   → Attach the smaller one to the merged list.
 * - Once one list ends, attach the remaining nodes of the other list.
 * 
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n) (new list created)
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // Merge while both lists have nodes
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach remaining nodes (if any)
        while (l1 != null) {
            curr.next = new ListNode(l1.val);
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null) {
            curr.next = new ListNode(l2.val);
            l2 = l2.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}

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
