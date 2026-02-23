package leet_code.Problem_744_Easy_Find_Smallest_Letter_Greater_Than_Target;

public class Solution {

    /**
     * Finds the smallest letter greater than target using Binary Search.
     * Strategy: Upper Bound Search with Wrap-around check.
     * Time: O(log N), Space: O(1).
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        // Wrap-around case: if target is greater/equal to the last character,
        // the answer must be the first character.
        if (target >= letters[n - 1]) {
            return letters[0];
        }

        int left = 0;
        int right = n - 1;

        // Binary Search for the first element > target
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                // mid might be the answer, try to find smaller on the left
                right = mid;
            } else {
                // mid is too small or equal, need to go right
                left = mid + 1;
            }
        }

        return letters[left];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] letters = { 'c', 'f', 'j' };
        System.out.println("Result 1: " + sol.nextGreatestLetter(letters, 'a')); // c
        System.out.println("Result 2: " + sol.nextGreatestLetter(letters, 'c')); // f
        System.out.println("Result 3: " + sol.nextGreatestLetter(letters, 'd')); // f
        System.out.println("Result 4: " + sol.nextGreatestLetter(letters, 'j')); // c (wrap around)
    }
}
