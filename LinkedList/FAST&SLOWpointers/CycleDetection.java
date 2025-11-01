/**
 * LeetCode Problem: 141. Linked List Cycle
 * 
 * Problem Statement:
 * Given the head of a linked list, determine if the linked list has a cycle in it.
 * A cycle exists if some node in the list can be reached again by continuously following the next pointer.
 * 
 * Example:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle linking the tail to the second node.
 * 
 * Approach (Floyd’s Cycle Detection Algorithm - Tortoise and Hare):
 * - Use two pointers: slow and fast.
 * - Move `slow` by one step and `fast` by two steps in each iteration.
 * - If there is a cycle, both pointers will eventually meet inside the cycle.
 * - If `fast` or `fast.next` becomes null, the list has no cycle.
 * 
 * Time Complexity: O(n)
 *  → Each pointer moves at most n steps.
 * 
 * Space Complexity: O(1)
 *  → Only two pointer variables used.
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle found
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
