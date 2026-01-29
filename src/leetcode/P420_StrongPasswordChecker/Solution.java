package leetcode.P420_StrongPasswordChecker;

public class Solution {

    /**
     * Problem 420: Strong Password Checker
     * Approach: Greedy Case-based Optimization
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c))
                hasLower = 1;
            else if (Character.isUpperCase(c))
                hasUpper = 1;
            else if (Character.isDigit(c))
                hasDigit = 1;
        }
        int missingTypes = 3 - (hasLower + hasUpper + hasDigit);

        if (n < 6) {
            return Math.max(6 - n, missingTypes);
        } else if (n <= 20) {
            int replacements = 0;
            for (int i = 2; i < n; i++) {
                if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i - 1) == password.charAt(i - 2)) {
                    int len = 2;
                    while (i < n && password.charAt(i) == password.charAt(i - 1)) {
                        len++;
                        i++;
                    }
                    replacements += len / 3;
                }
            }
            return Math.max(replacements, missingTypes);
        } else {
            int over = n - 20;
            int replacements = 0;
            int oneMod = 0;
            int twoMod = 0;

            for (int i = 2; i < n; i++) {
                if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i - 1) == password.charAt(i - 2)) {
                    int len = 2;
                    while (i < n && password.charAt(i) == password.charAt(i - 1)) {
                        len++;
                        i++;
                    }
                    replacements += len / 3;
                    if (len % 3 == 0)
                        oneMod += 1;
                    else if (len % 3 == 1)
                        twoMod += 2;
                }
            }

            int d1 = Math.min(over, oneMod);
            replacements -= d1;
            over -= d1;

            int d2 = Math.min(over, twoMod);
            replacements -= d2 / 2;
            over -= d2;

            int d3 = Math.min(over, replacements * 3);
            replacements -= d3 / 3;
            over -= d3;

            return (n - 20) + Math.max(replacements, missingTypes);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Basic examples
        runTest(solution, "a", 5);
        runTest(solution, "aA1", 3);
        runTest(solution, "1337C0d3", 0);
        runTest(solution, "aaa123", 1);
        runTest(solution, "aaa111", 2);
    }

    private static void runTest(Solution sol, String pass, int expected) {
        int result = sol.strongPasswordChecker(pass);
        System.out.println("Pass: \"" + pass + "\" -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
