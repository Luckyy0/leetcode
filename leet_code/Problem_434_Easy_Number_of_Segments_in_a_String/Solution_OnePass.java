package leet_code.Problem_434_Easy_Number_of_Segments_in_a_String;

public class Solution_OnePass {

    /**
     * Counts the number of segments in a string.
     * Strategy: Count characters that are not space AND follow a space (or are at
     * index 0).
     * Time: O(N), Space: O(1).
     */
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // A segment starts if current is not space and (prev is space or i is 0)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution_OnePass solution = new Solution_OnePass();
        System.out.println("Result 1: " + solution.countSegments("Hello, my name is John")); // 5
        System.out.println("Result 2: " + solution.countSegments("    ")); // 0
        System.out.println("Result 3: " + solution.countSegments("Hello")); // 1
    }
}
