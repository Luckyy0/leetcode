package leet_code.Problem_364_Medium_Nested_List_Weight_Sum_II;

import java.util.ArrayList;
import java.util.List;

// Same NestedInteger interface as previous problems
interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer val) {
        this.val = val;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
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
}

public class Solution_BFS {

    /**
     * Calculates Nested List Weight Sum II.
     * Uses Layer Sum Accumulation trick.
     * Time: O(N), Space: O(N).
     * 
     * Tính Tổng Trọng số Danh sách Lồng nhau II.
     * Sử dụng mẹo Tích lũy Tổng lớp.
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweightedSum = 0;
        int totalSum = 0;

        List<NestedInteger> currentLevel = nestedList;

        while (!currentLevel.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : currentLevel) {
                if (ni.isInteger()) {
                    unweightedSum += ni.getInteger();
                } else {
                    nextLevel.addAll(ni.getList());
                }
            }
            // The unweightedSum keeps accumulating all integers seen so far.
            // By adding it to totalSum at each level, we effectively weigh
            // earlier integers by totalDepth.
            totalSum += unweightedSum;
            currentLevel = nextLevel;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: [[1,1], 2, [1,1]] -> 8
        List<NestedInteger> l1 = new ArrayList<>();
        List<NestedInteger> sub1 = new ArrayList<>();
        sub1.add(new NestedIntegerImpl(1));
        sub1.add(new NestedIntegerImpl(1));
        List<NestedInteger> sub2 = new ArrayList<>();
        sub2.add(new NestedIntegerImpl(1));
        sub2.add(new NestedIntegerImpl(1));
        l1.add(new NestedIntegerImpl(sub1));
        l1.add(new NestedIntegerImpl(2));
        l1.add(new NestedIntegerImpl(sub2));
        System.out.println("Result 1: " + solution.depthSumInverse(l1));
    }
}
