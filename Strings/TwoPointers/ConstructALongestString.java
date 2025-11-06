/*
--------------------------------------------------------------
Problem: Construct the Longest New String
--------------------------------------------------------------
You are given three integers:
    x = number of "AA" pieces
    y = number of "BB" pieces
    z = number of "AB" pieces

You want to build the longest valid string using these pieces.
Each piece contributes length 2 to the final string:
    "AA" → length 2
    "BB" → length 2
    "AB" → length 2

Goal:
    Return the maximum possible length of the string you can build.

--------------------------------------------------------------
Your Approach (As Implemented):
--------------------------------------------------------------
- If x < y:
    You alternate AA and BB blocks starting with AA,
    and since BB are more, one extra BB can be added at the end.

- If x > y:
    Symmetric case where AA are more, so one extra AA can be added.

- If x == y:
    You can alternate perfectly, using all AA, BB, and AB blocks fully.

--------------------------------------------------------------
Time Complexity:
    O(1) — Direct formula calculation, no loops.
Space Complexity:
    O(1) — No extra memory used.
--------------------------------------------------------------
*/

class Solution {
    public int longestString(int x, int y, int z) {

        // Case 1: More BBs than AAs → extra BB block possible
        if(x < y){
            return 2*x + 2*(x+1) + 2*z;
        }

        // Case 2: More AAs than BBs → extra AA block possible
        if(x > y){
            return 2*(y+1) + 2*y + 2*z;
        }

        // Case 3: Equal number → use all blocks evenly
        if(x == y){
            return 2*(x + y + z);
        }

        // Safety return (should never reach here)
        return -1;
    }
}
