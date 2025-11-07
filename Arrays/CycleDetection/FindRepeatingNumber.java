/*
--------------------------------------------------------------
Problem: Find the Duplicate Number
--------------------------------------------------------------
You are given an integer array `nums` containing n + 1 integers 
where each integer is in the range [1, n] inclusive.

There is only **one repeated number** in `nums`, 
but it could be repeated more than once.

Return the duplicate number **without modifying the array** 
and using **only constant extra space**.

--------------------------------------------------------------
Approach: Floyd’s Tortoise and Hare (Cycle Detection)
--------------------------------------------------------------
Intuition:
- Treat the array as a linked list:
    - Each index represents a node.
    - The value at each index (nums[i]) is the "next pointer".
- Because there is a duplicate, the structure must form a cycle.
- The duplicate number is the **entry point of the cycle**.

Algorithm Steps:
1. Initialize two pointers:
       slow = nums[0]
       fast = nums[0]
2. Phase 1 → Find the intersection point inside the cycle.
       slow = nums[slow]
       fast = nums[nums[fast]]
       Loop until slow == fast
3. Phase 2 → Find the start of the cycle (duplicate number).
       slow = nums[0]
       while (slow != fast):
            slow = nums[slow]
            fast = nums[fast]
4. The node where they meet is the duplicate.

--------------------------------------------------------------
Example Dry Run:
nums = [1, 3, 4, 2, 2]

Index:  0  1  2  3  4
Value:  1  3  4  2  2

Path:
0 → 1 → 3 → 2 → 4 → 2 → 4 → ...

Duplicate = 2

--------------------------------------------------------------
Time Complexity:  O(n)
    - Each pointer moves at most 2n steps.
Space Complexity: O(1)
    - Uses only two pointers.
--------------------------------------------------------------
*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect intersection inside the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point of cycle (duplicate)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // duplicate number
    }
}

// Example index/value view:
// Index:  0 → 1 → 2 → 3 → 4
// Value:  1 → 3 → 4 → 2 → 2
// Duplicate: 2
