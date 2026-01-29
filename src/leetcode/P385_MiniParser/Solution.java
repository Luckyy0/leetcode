package leetcode.P385_MiniParser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    // Mock NestedInteger
    public static class NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        public NestedInteger() {
            this.list = new ArrayList<>();
        }

        public NestedInteger(int value) {
            this.val = value;
        }

        public boolean isInteger() {
            return val != null;
        }

        public Integer getInteger() {
            return val;
        }

        public void setInteger(int value) {
            this.val = value;
            this.list = null;
        }

        public void add(NestedInteger ni) {
            if (this.list == null)
                this.list = new ArrayList<>();
            this.list.add(ni);
        }

        public List<NestedInteger> getList() {
            return list;
        }

        @Override
        public String toString() {
            if (isInteger())
                return String.valueOf(val);
            return list.toString();
        }
    }

    /**
     * Problem 385: Mini Parser
     * Approach: Stack
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(D)
     */
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger curr = null;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                i++;
            } else if (c == ']') {
                if (!stack.isEmpty()) {
                    NestedInteger top = stack.pop();
                    top.add(curr);
                    curr = top;
                }
                i++;
            } else if (c == ',') {
                i++;
            } else {
                // Parse number
                int j = i;
                while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                curr.add(new NestedInteger(num));
                i = j;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "324" -> 324
        runTest(solution, "324");

        // "[123,[456,[789]]]"
        runTest(solution, "[123,[456,[789]]]");

        // "[-1]"
        runTest(solution, "[-1]");
    }

    private static void runTest(Solution s, String str) {
        NestedInteger result = s.deserialize(str);
        System.out.println("Input: " + str + " -> " + result);
        System.out.println("-----------------");
    }
}
