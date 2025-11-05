class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            // Move left pointer to next valid alphanumeric character
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;

            // Move right pointer to previous valid alphanumeric character
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
