package leetcode.P423_ReconstructOriginalDigitsFromEnglish;

public class Solution {

    /**
     * Problem 423: Reconstruct Original Digits from English
     * Approach: Unique Character Deduction
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public String originalDigits(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] count = new int[10];
        // Unique markers
        count[0] = freq['z' - 'a']; // zero
        count[2] = freq['w' - 'a']; // two
        count[4] = freq['u' - 'a']; // four
        count[6] = freq['x' - 'a']; // six
        count[8] = freq['g' - 'a']; // eight

        // Derived markers
        count[3] = freq['h' - 'a'] - count[8]; // three and eight
        count[5] = freq['f' - 'a'] - count[4]; // four and five
        count[7] = freq['s' - 'a'] - count[6]; // six and seven
        count[1] = freq['o' - 'a'] - count[0] - count[2] - count[4]; // zero, one, two, four
        count[9] = freq['i' - 'a'] - count[5] - count[6] - count[8]; // five, six, eight, nine

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < count[i]; k++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "owoztneoer" -> "012"
        runTest(solution, "owoztneoer", "012");

        // "fviefuro" -> "45"
        runTest(solution, "fviefuro", "45");

        // "nine" -> "9"
        runTest(solution, "nine", "9");
    }

    private static void runTest(Solution sol, String s, String expected) {
        String result = sol.originalDigits(s);
        System.out.println("Input: " + s + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
