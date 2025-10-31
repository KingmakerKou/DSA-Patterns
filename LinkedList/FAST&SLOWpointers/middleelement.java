/**
 * LeetCode Problem: 876. Middle of the Linked List
 * 
 * Problem Statement:
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * 
 * Example:
 * Input: [1,2,3,4,5]
 * Output: Node 3 (The middle node)
 * 
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 (The second middle node)
 * 
 * Approach:
 * - Use two pointers: "slow" and "fast".
 * - Move "fast" by 2 steps and "slow" by 1 step.
 * - When "fast" reaches the end, "slow" will be at the middle.
 * 
 * Time Complexity: O(n)
 *  → Each node is visited at most once.
 * 
 * Space Complexity: O(1)
 *  → No extra space used apart from a few pointer variables.
 */

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow; // Slow pointer now points to the middle node
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
