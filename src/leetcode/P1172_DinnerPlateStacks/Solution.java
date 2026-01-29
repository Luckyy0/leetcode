package leetcode.P1172_DinnerPlateStacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

class DinnerPlates {
    List<Stack<Integer>> stacks;
    TreeSet<Integer> available; // Indices of non-full stacks
    int capacity;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        available = new TreeSet<>();
    }

    public void push(int val) {
        if (available.isEmpty()) {
            stacks.add(new Stack<>());
            available.add(stacks.size() - 1);
        }

        int idx = available.first();
        Stack<Integer> st = stacks.get(idx);
        st.push(val);

        if (st.size() == capacity) {
            available.remove(idx);
        }
    }

    public int pop() {
        if (stacks.isEmpty())
            return -1;
        // Clean trailing empty stacks
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
            available.remove(stacks.size()); // Remove valid index from available as it doesn't exist anymore?
            // Wait, if I remove stack index X, X is no longer valid.
            // If it was in available, remove it.
        }
        if (stacks.isEmpty())
            return -1;

        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }

        Stack<Integer> st = stacks.get(index);
        int val = st.pop();

        // Since we popped, it has space now. Add to available.
        available.add(index);

        return val;
    }
}
