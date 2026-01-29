package leetcode.P744_FindSmallestLetterGreaterThanTarget;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Wrap around: if left == n, return letters[0]
        return letters[left % n];
    }
}
