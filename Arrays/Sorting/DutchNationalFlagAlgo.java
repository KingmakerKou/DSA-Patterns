/**
 * LeetCode Problem: 75. Sort Colors
 * Approach: Dutch National Flag Algorithm by Edsger Dijkstra
 * 
 * Given an array nums with n objects colored red (0), white (1), or blue (2),
 * sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white, and blue.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class SortColors {

    // Helper method to swap elements at two indices
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Core algorithm (Dutch National Flag)
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    // Sample test
    public static void main(String[] args) {
        SortColors solution = new SortColors();

        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println("Before: " + Arrays.toString(nums));

        solution.sortColors(nums);

        System.out.println("After:  " + Arrays.toString(nums));
        // Output: [0, 0, 1, 1, 2, 2]
    }
}
