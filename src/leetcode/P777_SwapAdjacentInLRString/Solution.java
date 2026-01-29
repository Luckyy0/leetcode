package leetcode.P777_SwapAdjacentInLRString;

class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        int i = 0, j = 0;
        int n = start.length();

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X')
                i++;
            while (j < n && end.charAt(j) == 'X')
                j++;

            if (i == n || j == n)
                break;

            if (start.charAt(i) != end.charAt(j))
                return false;

            // L can only move left, so start index must be >= end index
            if (start.charAt(i) == 'L' && i < j)
                return false;
            // R can only move right, so start index must be <= end index
            if (start.charAt(i) == 'R' && i > j)
                return false;

            i++;
            j++;
        }
        return true;
    }
}
