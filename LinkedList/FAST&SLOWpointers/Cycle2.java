/**
 * LeetCode Problem: 142. Linked List Cycle II
 * 
 * Problem:
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * 
 * Approach (Floyd’s Tortoise and Hare Algorithm):
 * 1. Use two pointers (slow and fast).
 * 2. Move `slow` by 1 and `fast` by 2 steps.
 * 3. If they meet, there’s a cycle.
 * 4. To find the start of the cycle:
 *    - Move one pointer to `head`.
 *    - Move both one step at a time — the point they meet again is the cycle start.
 * 
 * Time Complexity: O(n)
 *   → Each pointer traverses the list at most twice.
 * Space Complexity: O(1)
 *   → Uses constant extra space.
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Step 2: When slow == fast, a cycle exists
            if (slow == fast) {
                // Step 3: Move one pointer to head
                ListNode temp = head;

                // Step 4: Move both one step at a time
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }

                // Step 5: The node where they meet is the start of the cycle
                return temp;
            }
        }

        // No cycle found
        return null;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
