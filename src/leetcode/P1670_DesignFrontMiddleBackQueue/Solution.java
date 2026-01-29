package leetcode.P1670_DesignFrontMiddleBackQueue;

import java.util.Deque;
import java.util.LinkedList;

class FrontMiddleBackQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
            left.offerLast(val);
        } else if (left.size() < right.size()) {
            left.offerLast(val);
        } else {
            // Equal size
            right.offerFirst(val);
        }
        // Balance not usually needed if logic correct, but check invariants
        balance();
    }

    public void pushBack(int val) {
        right.offerLast(val);
        balance();
    }

    public int popFront() {
        if (isEmpty())
            return -1;
        int val;
        if (left.isEmpty()) {
            val = right.pollFirst();
        } else {
            val = left.pollFirst();
        }
        balance();
        return val;
    }

    public int popMiddle() {
        if (isEmpty())
            return -1;
        int val;
        if (left.size() == right.size()) {
            val = left.pollLast();
        } else {
            val = right.pollFirst();
        }
        balance();
        return val;
    }

    public int popBack() {
        if (isEmpty())
            return -1;
        int val = right.pollLast();
        balance();
        return val;
    }

    private boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    // Invariant: size(right) == size(left) or size(right) == size(left) + 1
    private void balance() {
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }
        if (right.size() > left.size() + 1) {
            left.offerLast(right.pollFirst());
        }
    }
}
