package leetcode.P331_VerifyPreorderSerializationOfABinaryTree;

public class Solution {

    /**
     * Problem 331: Verify Preorder Serialization of a Binary Tree
     * Approach: Slot Counting
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N) due to split, or O(1) if parsing
     */
    public boolean isValidSerialization(String preorder) {
        int slots = 1;

        // We can parse manually to reach O(1) space, but split is clearer for standard
        // logic
        String[] nodes = preorder.split(",");

        for (String node : nodes) {
            slots--;

            if (slots < 0) {
                return false;
            }

            if (!node.equals("#")) {
                slots += 2;
            }
        }

        return slots == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "9,3,4,#,#,1,#,#,2,#,6,#,#" -> true
        runTest(solution, "9,3,4,#,#,1,#,#,2,#,6,#,#", true);

        // "1,#" -> false
        runTest(solution, "1,#", false);

        // "9,#,#,1" -> false
        runTest(solution, "9,#,#,1", false);
    }

    private static void runTest(Solution s, String p, boolean expected) {
        boolean result = s.isValidSerialization(p);
        System.out.println("Input: " + p + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
