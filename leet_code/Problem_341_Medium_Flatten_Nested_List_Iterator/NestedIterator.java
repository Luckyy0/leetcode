package leet_code.Problem_341_Medium_Flatten_Nested_List_Iterator;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

// Mock interface for NestedInteger (same as previous problem)
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

public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;

    /**
     * Stack-based iterator for Nested List.
     * Lazy unpacking in hasNext().
     * Time: O(N) total, Space: O(N).
     * 
     * Bộ lặp dựa trên ngăn xếp cho Danh sách Lồng nhau.
     * Giải nén lười trong hasNext().
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        // Push elements from back to front so first element is at top
        // Đẩy các phần tử từ sau ra trước để phần tử đầu tiên ở trên cùng
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            }
            // It's a list, flatten it one level
            stack.pop();
            List<NestedInteger> list = top.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }

    // Main for testing
    public static void main(String[] args) {
        // Test Case: [[1,1], 2, [1,1]]
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

        NestedIterator iter = new NestedIterator(l1);
        System.out.print("Flattened: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
