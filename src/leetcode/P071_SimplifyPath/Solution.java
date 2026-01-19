package leetcode.P071_SimplifyPath;

import java.util.Stack;

public class Solution {

    /**
     * Problem 71: Simplify Path
     * Approach: Stack
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // Split by /
        String[] components = path.split("/");

        for (String component : components) {
            // Ignore empty strings (from multiple slashes) and current directory .
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }

            // Go up one level
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Navigate into directory
                stack.push(component);
            }
        }

        // Reconstruct path
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "/home/", "/home");
        runTest(solution, "/../", "/");
        runTest(solution, "/home//foo/", "/home/foo");
        runTest(solution, "/a/./b/../../c/", "/c");
    }

    private static void runTest(Solution s, String path, String expected) {
        System.out.println("Input: \"" + path + "\"");
        String result = s.simplifyPath(path);
        System.out.println("Output: \"" + result + "\" (Expected: \"" + expected + "\")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
