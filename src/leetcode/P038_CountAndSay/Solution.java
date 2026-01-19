package leetcode.P038_CountAndSay;

public class Solution {

    /**
     * Problem 38: Count and Say
     * Approach: Iterative Generation
     * Time Complexity: O(Length of sequence)
     * Space Complexity: O(Length of sequence)
     */
    public String countAndSay(int n) {
        if (n <= 0)
            return "";
        String s = "1";

        for (int i = 1; i < n; i++) {
            s = getNext(s);
        }

        return s;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int count = 1;
            while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count).append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 1, "1");
        runTest(solution, 4, "1211");
        runTest(solution, 5, "111221");
    }

    private static void runTest(Solution s, int n, String expected) {
        System.out.println("Input: " + n);
        String result = s.countAndSay(n);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
