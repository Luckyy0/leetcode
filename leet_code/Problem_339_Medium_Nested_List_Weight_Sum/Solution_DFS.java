package leet_code.Problem_339_Medium_Nested_List_Weight_Sum;

import java.util.List;
import java.util.ArrayList;

// Mock interface for NestedInteger since it's an internal interface on LeetCode
// Giao diện giả cho NestedInteger vì nó là giao diện nội bộ trên LeetCode
interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

// Simple implementation for testing
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

public class Solution_DFS {

    /**
     * Calculates nested list weight sum.
     * Uses DFS.
     * Time: O(N), Space: O(D).
     * 
     * Tính tổng trọng số danh sách lồng nhau.
     * Sử dụng DFS.
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger item : list) {
            if (item.isInteger()) {
                sum += item.getInteger() * depth;
            } else {
                sum += dfs(item.getList(), depth + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: [[1,1], 2, [1,1]]
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

        System.out.println("Sum 1: " + solution.depthSum(l1)); // 10

        // Test Case 2: [1,[4,[6]]]
        List<NestedInteger> l2 = new ArrayList<>();
        l2.add(new NestedIntegerImpl(1));

        List<NestedInteger> sub4 = new ArrayList<>();
        sub4.add(new NestedIntegerImpl(4));
        List<NestedInteger> sub6 = new ArrayList<>();
        sub6.add(new NestedIntegerImpl(6));
        sub4.add(new NestedIntegerImpl(sub6)); // [4, [6]]

        l2.add(new NestedIntegerImpl(sub4)); // [1, [4, [6]]]

        System.out.println("Sum 2: " + solution.depthSum(l2)); // 27
    }
}
