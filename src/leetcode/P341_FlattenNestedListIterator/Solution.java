package leetcode.P341_FlattenNestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution {

    // Mock NestedInteger
    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    // Implementation for testing
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
     * Problem 341: Flatten Nested List Iterator
     * Approach: Stack
     */
    public static class NestedIterator implements Iterator<Integer> {
        private Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            flatten(nestedList);
        }

        // Push in reverse order
        private void flatten(List<NestedInteger> list) {
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }

        @Override
        public Integer next() {
            if (!hasNext())
                return null;
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger curr = stack.peek();
                if (curr.isInteger()) {
                    return true;
                }
                stack.pop();
                flatten(curr.getList());
            }
            return false;
        }
    }

    public static void main(String[] args) {
        // [[1,1],2,[1,1]]
        List<NestedInteger> list = new ArrayList<>();

        NestedIntegerImpl l1 = new NestedIntegerImpl();
        l1.add(new NestedIntegerImpl(1));
        l1.add(new NestedIntegerImpl(1));

        NestedIntegerImpl l2 = new NestedIntegerImpl(2);

        NestedIntegerImpl l3 = new NestedIntegerImpl();
        l3.add(new NestedIntegerImpl(1));
        l3.add(new NestedIntegerImpl(1));

        list.add(l1);
        list.add(l2);
        list.add(l3);

        NestedIterator iterator = new NestedIterator(list);
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        System.out.println("Result: " + result); // Expected: [1, 1, 2, 1, 1]
    }
}
