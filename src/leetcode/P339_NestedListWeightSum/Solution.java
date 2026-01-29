package leetcode.P339_NestedListWeightSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Mock NestedInteger interface for compilation and testing
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a
        // nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a
        // single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested
        // list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    // Simple Implementation for Testing
    public static class NestedIntegerImpl implements NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        public NestedIntegerImpl(Integer val) {
            this.val = val;
        }

        public NestedIntegerImpl() {
            this.list = new ArrayList<>();
        }

        public boolean isInteger() {
            return val != null;
        }

        public Integer getInteger() {
            return val;
        }

        public void setInteger(int value) {
            this.val = value;
        }

        public void add(NestedInteger ni) {
            if (this.list == null)
                this.list = new ArrayList<>();
            this.list.add(ni);
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }

    /**
     * Problem 339: Nested List Weight Sum
     * Approach: DFS
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(D)
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += dfs(ni.getList(), depth + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,1],2,[1,1]] -> 10
        List<NestedInteger> list1 = new ArrayList<>();
        NestedInteger l1 = new NestedIntegerImpl(); // [1, 1]
        l1.add(new NestedIntegerImpl(1));
        l1.add(new NestedIntegerImpl(1));

        NestedInteger l2 = new NestedIntegerImpl(2); // 2

        NestedInteger l3 = new NestedIntegerImpl(); // [1, 1]
        l3.add(new NestedIntegerImpl(1));
        l3.add(new NestedIntegerImpl(1));

        list1.add(l1);
        list1.add(l2);
        list1.add(l3);

        runTest(solution, list1, 10);

        // [1,[4,[6]]] -> 27
        List<NestedInteger> list2 = new ArrayList<>();
        list2.add(new NestedIntegerImpl(1)); // 1

        NestedInteger sub1 = new NestedIntegerImpl(); // [4, [6]]
        sub1.add(new NestedIntegerImpl(4));

        NestedInteger sub2 = new NestedIntegerImpl(); // [6]
        sub2.add(new NestedIntegerImpl(6));

        sub1.add(sub2);
        list2.add(sub1);

        runTest(solution, list2, 27);
    }

    private static void runTest(Solution s, List<NestedInteger> list, int expected) {
        int result = s.depthSum(list);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
