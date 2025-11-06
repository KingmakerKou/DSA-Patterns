import java.util.*;

class Solution {

    /**
     * Approach:
     * 1. Sort both arrays -> seats[] and students[].
     * 2. Pair each student with the corresponding seat at the same index.
     *    Why? Sorting ensures closest positions align, minimizing total movement.
     * 3. Sum the absolute difference between seats[i] and students[i].
     *
     * Intuition:
     * Greedy + Sorting.
     * Matching the smallest student position with the smallest seat position ensures 
     * the minimal total movement because it avoids large unnecessary jumps.
     *
     * Time Complexity: O(n log n)
     *  - Sorting takes O(n log n)
     *  - One pass to calculate movement takes O(n)
     *
     * Space Complexity: O(1)
     *  - No extra space (apart from sorting in-place)
     */

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;
        for(int i = 0; i < seats.length; i++){
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }
}
