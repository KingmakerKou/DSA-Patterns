// LeetCode 11: Container With Most Water
// -------------------------------------------------------------
// ✅ Approach:
// Use the two-pointer technique:
// 1. Initialize two pointers — left at 0 and right at n-1.
// 2. Calculate the area formed by the two lines: 
//        area = (right - left) * min(height[left], height[right])
// 3. Keep track of the maximum area encountered.
// 4. Move the pointer with the smaller height inward, because the limiting factor 
//    is always the shorter line — moving it might lead to a taller one and a bigger area.
// 5. Continue until the two pointers meet.
//
// -------------------------------------------------------------
// 🧠 Time Complexity:  O(n)
// Each element is processed at most once (one pass).
//
// 💾 Space Complexity: O(1)
// Uses only constant extra space.
//
// -------------------------------------------------------------
// Example:
// Input:  [1,8,6,2,5,4,8,3,7]
// Output: 49  (between lines 2 and 9 -> min(8,7)*7 = 49)
// -------------------------------------------------------------

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;       // Number of vertical lines
        int l = 0, r = n - 1;        // Initialize two pointers
        int maxi = 0;                // Track maximum area

        // Move pointers towards each other
        while (l < r) {
            // Calculate area formed by lines at l and r
            int amt = (r - l) * Math.min(height[l], height[r]);
            maxi = Math.max(maxi, amt);  // Update max area if needed

            // Move the pointer pointing to the shorter line
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxi;  // Return maximum area found
    }
}
