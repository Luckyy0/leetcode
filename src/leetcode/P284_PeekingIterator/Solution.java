package leetcode.P284_PeekingIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {

    /**
     * Problem 284: Peeking Iterator
     * Approach: Cache next element
     * 
     * Theoretical Basis:
     * - Look ahead 1 step.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer nextElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (this.iterator.hasNext()) {
                nextElement = this.iterator.next();
            } else {
                nextElement = null;
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer current = nextElement;
            if (iterator.hasNext()) {
                nextElement = iterator.next();
            } else {
                nextElement = null;
            }
            return current;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }

    public static void main(String[] args) {
        // [1, 2, 3]
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        PeekingIterator iter = new PeekingIterator(list.iterator());

        System.out.println("next(): " + iter.next()); // 1
        System.out.println("peek(): " + iter.peek()); // 2
        System.out.println("next(): " + iter.next()); // 2
        System.out.println("next(): " + iter.next()); // 3
        System.out.println("hasNext(): " + iter.hasNext()); // false
    }
}
