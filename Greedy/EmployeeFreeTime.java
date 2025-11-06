import java.util.*;

/**
 * Problem: Given each employee's working hours as a list of intervals,
 * find the common free time intervals across all employees.
 *
 * Example:
 * Input: [[[1,3],[6,7]], [[2,4]], [[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 *
 * Approach:
 * 1. Flatten all employee intervals into one list.
 * 2. Sort intervals by start time.
 * 3. Merge overlapping intervals.
 * 4. Find gaps between merged intervals (free times).
 */

public class Solution {

    public static ArrayList<ArrayList<Integer>> findFreeIntervals(
            ArrayList<ArrayList<ArrayList<Integer>>> schedules) {

        ArrayList<ArrayList<Integer>> all = new ArrayList<>();

        // Step 1: Flatten all employee intervals
        for (ArrayList<ArrayList<Integer>> employee : schedules) {
            all.addAll(employee);
        }

        // Step 2: Sort intervals by start time
        Collections.sort(all, (a, b) -> a.get(0) - b.get(0));

        // Step 3: Merge overlapping intervals
        ArrayList<ArrayList<Integer>> merged = new ArrayList<>();
        ArrayList<Integer> prev = all.get(0);

        for (int i = 1; i < all.size(); i++) {
            ArrayList<Integer> curr = all.get(i);
            if (curr.get(0) <= prev.get(1)) {
                // Overlapping, merge them
                prev.set(1, Math.max(prev.get(1), curr.get(1)));
            } else {
                // Non-overlapping, push previous interval
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev); // Add the last interval

        // Step 4: Find free time gaps between merged intervals
        ArrayList<ArrayList<Integer>> freeTimes = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            int start = merged.get(i - 1).get(1);
            int end = merged.get(i).get(0);
            if (start < end) { // Only add if there's an actual gap
                freeTimes.add(new ArrayList<>(Arrays.asList(start, end)));
            }
        }

        return freeTimes;
    }
