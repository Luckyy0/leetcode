package leetcode.P281_ZigzagIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * Problem 281: Zigzag Iterator
     * Approach: Queue of Iterators
     * 
     * Theoretical Basis:
     * - Cycle through available iterators using a Queue.
     * 
     * Time Complexity: O(1) per operation
     * Space Complexity: O(K) where k is number of lists (2 here)
     */
    public static class ZigzagIterator {

        private Queue<Iterator<Integer>> queue;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            queue = new LinkedList<>();
            if (!v1.isEmpty())
                queue.offer(v1.iterator());
            if (!v2.isEmpty())
                queue.offer(v2.iterator());
        }

        public int next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();

            Iterator<Integer> it = queue.poll();
            int res = it.next();

            if (it.hasNext()) {
                queue.offer(it);
            }

            return res;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        // v1=[1,2], v2=[3,4,5,6] -> [1,3,2,4,5,6]
        List<Integer> v1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> v2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6));

        ZigzagIterator i = new ZigzagIterator(v1, v2);
        List<Integer> result = new ArrayList<>();
        while (i.hasNext()) {
            result.add(i.next());
        }

        System.out.println("Result: " + result);

        if (result.equals(Arrays.asList(1, 3, 2, 4, 5, 6))) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
