# 281. Zigzag Iterator / Bộ Lặp Zigzag

## Problem Description / Mô tả bài toán
Given two vectors of integers `v1` and `v2`, implement an iterator to return their elements alternately.
Cho hai vector số nguyên `v1` và `v2`, hãy triển khai một bộ lặp để trả về các phần tử của chúng xen kẽ nhau.

Implement the `ZigzagIterator` class:
- `ZigzagIterator(List<Integer> v1, List<Integer> v2)` initializes the object with the two vectors `v1` and `v2`.
- `boolean hasNext()` returns `true` if the iterator has more elements.
- `int next()` returns the next element in the iterator.

### Example 1:
```text
Input: v1 = [1,2], v2 = [3,4,5,6]
Output: [1,3,2,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned is: [1,3,2,4,5,6].
```

### Example 2:
```text
Input: v1 = [1], v2 = []
Output: [1]
```

### Example 3:
```text
Input: v1 = [], v2 = [1]
Output: [1]
```

## Constraints / Ràng buộc
- `0 <= v1.length, v2.length <= 1000`
- `1 <= v1.length + v2.length <= 2000`
- `-2^31 <= v1[i], v2[i] <= 2^31 - 1`

**Follow up**: What if you are given `k` vectors? How well can your code be extended to such cases?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Queue of Iterators / Hàng Đợi Bộ Lặp
To handle 2 (or k) vectors in a zigzag manner:
1.  Store iterators for each non-empty vector in a `Queue`.
2.  `next()`:
    - Poll an iterator from the queue.
    - Get its next element.
    - If the iterator still has elements, put it back at the end of the queue.
3.  `hasNext()`:
    - Check if the queue is empty.

This approach scales perfectly to `k` vectors.

### Algorithm
1.  Initialize `Queue<Iterator>`. Add `v1.iterator()` and `v2.iterator()` if they have next.
2.  `next()`:
    - `it = queue.poll()`.
    - `res = it.next()`.
    - `if it.hasNext() queue.offer(it)`.
    - `return res`.

### Complexity / Độ phức tạp
- **Time**: O(1) for next/hasNext.
- **Space**: O(K) where K is number of vectors (here 2).

---

## Analysis / Phân tích

### Approach: Queue of Iterators

**Edge Cases**:
1.  **Both empty**: Queue empty.
2.  **One empty**: Queue has 1 iterator.
3.  **Different lengths**: Queue logic handles specific lengths naturally.

---
