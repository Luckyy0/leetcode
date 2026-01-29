package leetcode.P418_SentenceScreenFitting;

public class Solution {

    /**
     * Problem 418: Sentence Screen Fitting
     * Approach: Joint String Simulation
     * 
     * Time Complexity: O(rows + length_of_sentence)
     * Space Complexity: O(length_of_sentence)
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int n = s.length();
        int start = 0;

        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % n) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % n) != ' ') {
                    start--;
                }
            }
        }

        return start / n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // rows = 2, cols = 8, sentence = ["hello", "world"] -> 1
        String[] s1 = { "hello", "world" };
        runTest(solution, s1, 2, 8, 1);

        // rows = 3, cols = 6, sentence = ["a", "bcd", "e"] -> 2
        String[] s2 = { "a", "bcd", "e" };
        runTest(solution, s2, 3, 6, 2);

        // rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"] -> 1
        String[] s3 = { "I", "had", "apple", "pie" };
        runTest(solution, s3, 4, 5, 1);
    }

    private static void runTest(Solution sol, String[] sentence, int rows, int cols, int expected) {
        int result = sol.wordsTyping(sentence, rows, cols);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
