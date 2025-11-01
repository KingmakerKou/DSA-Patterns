/**
 * LeetCode Problem: 160. Intersection of Two Linked Lists
 * 
 * Problem Statement:
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection, return null.
 * 
 * Example:
 * Input: A = [4,1,8,4,5], B = [5,6,1,8,4,5]
 * Output: Reference to node with value = 8
 * 
 * Approach:
 * - Use two pointers `temp1` and `temp2`, starting at headA and headB.
 * - Traverse both lists simultaneously.
 * - When one pointer reaches the end, redirect it to the head of the other list.
 * - If the lists intersect, both pointers will eventually meet at the intersection node.
 * - If not, both will become null at the same time.
 * 
 * Why this works:
 * - The total distance covered by both pointers will be the same (A + B).
 * - This ensures they meet at the intersection node if one exists.
 * 
 * Time Complexity: O(m + n)
 *  → Each pointer traverses both lists once at most.
 * 
 * Space Complexity: O(1)
 *  → Only two pointer variables used, no extra data structures.
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? headB : temp1.next;
            temp2 = (temp2 == null) ? headA : temp2.next;
        }

        return temp1; // Either intersection node or null
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { 
 *         this.val = val; 
 *         this.next = next; 
 *     }
 * }
 */
