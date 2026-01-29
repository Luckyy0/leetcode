package leetcode.P364_NestedListWeightSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Mock NestedInteger
    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    // Implementation
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

        public List<NestedInteger> getList() {
            return list;
        }

        public void add(NestedInteger ni) {
            if (this.list == null)
                this.list = new ArrayList<>();
            this.list.add(ni);
        }
    }

    /**
     * Problem 364: Nested List Weight Sum II
     * Approach: BFS Accumulation
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int weightedSum = 0;
        int unweightedSum = 0;

        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();

            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    unweightedSum += ni.getInteger();
                } else {
                    nextLevel.addAll(ni.getList());
                }
            }

            weightedSum += unweightedSum;
            nestedList = nextLevel;
        }

        return weightedSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,1],2,[1,1]] -> 8
        List<NestedInteger> list1 = new ArrayList<>();
        NestedIntegerImpl l1 = new NestedIntegerImpl();
        l1.add(new NestedIntegerImpl(1));
        l1.add(new NestedIntegerImpl(1));

        NestedIntegerImpl l2 = new NestedIntegerImpl(2);

        NestedIntegerImpl l3 = new NestedIntegerImpl();
        l3.add(new NestedIntegerImpl(1));
        l3.add(new NestedIntegerImpl(1));

        list1.add(l1);
        list1.add(l2);
        list1.add(l3);

        runTest(solution, list1, 8);

        // [1,[4,[6]]] -> 17
        // depth 1: 1 (weight 3) -> 3
        // depth 2: 4 (weight 2) -> 8
        // depth 3: 6 (weight 1) -> 6
        // Total: 17
        // Execution:
        // L1: unweighted=1. weighted=1. next=[4,[6]].
        // L2: unweighted=1+4=5. weighted=1+5=6. next=[[6]].
        // L3: unweighted=5. wait, need to flatten [6]. next=[6]. Int processing inside
        // 'nextLevel' logic loop?
        // Wait, loop iterates `nestedList`.
        // Iter 1: Process 1. unweighted=1. list=[4,[6]]. weighted=1.
        // Iter 2: Process 4. unweighted=1+4=5. list=[[6]]. weighted=1+5=6.
        // Iter 3: Process list [6]. No ints. next=[6]. unweighted=5. weighted=6+5=11.
        // Iter 4: Process 6. unweighted=5+6=11. next=[]. weighted=11+11=22.
        // Result 22 vs 17?
        // Let's trace carefully manually.
        // Input: [1,[4,[6]]]
        // Level 1: [1], [[4,[6]]]
        // Int: 1. Unweighted = 1.
        // List: Add [4,[6]] to next.
        // Weighted += 1 = 1.
        // Level 2: [4,[6]] -> 4, [6] (elements of [4,[6]])
        // Int: 4. Unweighted = 1 + 4 = 5.
        // List: Add [6] to next.
        // Weighted += 5 = 6.
        // Level 3: [6] -> 6
        // Int: 6. Unweighted = 5 + 6 = 11.
        // List: -
        // Weighted += 11 = 17.
        // Level 4: Empty.
        // Result 17. Correct.

        List<NestedInteger> list2 = new ArrayList<>();
        list2.add(new NestedIntegerImpl(1));

        NestedIntegerImpl sub1 = new NestedIntegerImpl();
        sub1.add(new NestedIntegerImpl(4));
        NestedIntegerImpl sub2 = new NestedIntegerImpl();
        sub2.add(new NestedIntegerImpl(6));
        sub1.add(sub2);

        list2.add(sub1);

        runTest(solution, list2, 17);
    }

    private static void runTest(Solution s, List<NestedInteger> list, int expected) {
        int result = s.depthSumInverse(list);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
