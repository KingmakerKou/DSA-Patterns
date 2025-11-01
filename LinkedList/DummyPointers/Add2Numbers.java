/**
 * LeetCode Problem: 2. Add Two Numbers
 * 
 * Problem:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * 
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807
 * 
 * Approach:
 * - Use a dummy node to build the resulting list.
 * - Traverse both lists while any of them has digits left or carry is non-zero.
 * - Add corresponding digits + carry, compute new carry, and create a new node for each digit.
 * 
 * Time Complexity: O(max(m, n))
 * Space Complexity: O(max(m, n))
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with carry from previous step

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Compute new digit and carry
            carry = sum / 10;
            int digit = sum % 10;

            // Create new node for the current digit
            curr.next = new ListNode(digit);
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
