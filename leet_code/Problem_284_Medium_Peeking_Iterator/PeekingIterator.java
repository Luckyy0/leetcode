package leet_code.Problem_284_Medium_Peeking_Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;
    private Integer nextVal; // Cache for the next element

    /**
     * Initializes the PeekingIterator.
     * Uses pre-fetching strategy to support peek.
     * Time: O(1), Space: O(1).
     * 
     * Khởi tạo PeekingIterator.
     * Sử dụng chiến lược lấy trước để hỗ trợ peek.
     */
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        // Pre-fetch the first element
        // Lấy trước phần tử đầu tiên
        if (iterator.hasNext()) {
            nextVal = iterator.next();
        } else {
            nextVal = null;
        }
    }

    /**
     * Returns the next element in the iteration without advancing the iterator.
     * Trả về phần tử tiếp theo trong vòng lặp mà không di chuyển iterator.
     */
    public Integer peek() {
        return nextVal;
    }

    /**
     * Returns the next element in the iteration and advances the iterator.
     * Trả về phần tử tiếp theo trong vòng lặp và di chuyển iterator.
     */
    @Override
    public Integer next() {
        if (nextVal == null) {
            throw new NoSuchElementException();
        }
        Integer res = nextVal;

        // Advance the iterator
        // Di chuyển iterator
        if (iterator.hasNext()) {
            nextVal = iterator.next();
        } else {
            nextVal = null;
        }

        return res;
    }

    /**
     * Returns true if the iteration has more elements.
     * Trả về true nếu vòng lặp còn phần tử.
     */
    @Override
    public boolean hasNext() {
        return nextVal != null;
    }
}
