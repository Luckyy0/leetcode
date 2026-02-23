package leet_code.Problem_385_Medium_Mini_Parser;

import java.util.*;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
    // public NestedInteger();

    // Constructor initializes a single integer.
    // public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

// Mock implementation for local testing
class NestedIntegerImpl implements NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedIntegerImpl() {
        list = new ArrayList<>();
    }

    public NestedIntegerImpl(int value) {
        this.val = value;
    }

    @Override
    public boolean isInteger() {
        return val != null;
    }

    @Override
    public Integer getInteger() {
        return val;
    }

    @Override
    public void setInteger(int value) {
        this.val = value;
    }

    @Override
    public void add(NestedInteger ni) {
        if (list != null)
            list.add(ni);
    }

    @Override
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

public class Solution_Stack {

    /**
     * Parses a string into a NestedInteger.
     * Uses an iterative stack-based approach.
     * Time: O(N), Space: O(D).
     * 
     * Phân tích một chuỗi thành NestedInteger.
     * Sử dụng phương pháp lặp dựa trên ngăn xếp.
     */
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty())
            return null;

        // Handle single integer case
        if (!s.startsWith("[")) {
            return new NestedIntegerImpl(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = null;
        int l = 0; // left pointer for parsing integers

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            if (ch == '[') {
                NestedInteger ni = new NestedIntegerImpl();
                if (!stack.isEmpty()) {
                    stack.peek().add(ni);
                }
                stack.push(ni);
                l = r + 1;
            } else if (ch == ']' || ch == ',') {
                // If there's a number before this marker, parse and add it
                if (r > l) {
                    int val = Integer.parseInt(s.substring(l, r));
                    stack.peek().add(new NestedIntegerImpl(val));
                }
                l = r + 1;

                if (ch == ']') {
                    res = stack.pop();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: "324"
        System.out.println("Result 1: " + solution.deserialize("324"));

        // Test Case 2: "[123,[456,[789]]]"
        System.out.println("Result 2: " + solution.deserialize("[123,[456,[789]]]"));
    }
}
