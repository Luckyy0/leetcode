package leet_code.Problem_281_Medium_Zigzag_Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

public class ZigzagIterator {

    private Queue<Iterator<Integer>> queue;

    /**
     * Initializes the Zigzag Iterator.
     * Uses a Queue to manage iterators for Round-Robin access.
     * Time: O(K) for init, O(1) for next/hasNext.
     * Space: O(K) where K is number of vectors (2 here).
     * 
     * Khởi tạo Iterator Zigzag.
     * Sử dụng Hàng đợi để quản lý các iterator cho truy cập Round-Robin.
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) {
            queue.offer(v1.iterator());
        }
        if (!v2.isEmpty()) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }

        Iterator<Integer> iter = queue.poll();
        int val = iter.next();

        if (iter.hasNext()) {
            queue.offer(iter);
        }

        return val;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2);
        List<Integer> v2 = Arrays.asList(3, 4, 5, 6);
        ZigzagIterator i = new ZigzagIterator(v1, v2);

        System.out.print("Zigzag: ");
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        // Output: 1 3 2 4 5 6
    }
}
