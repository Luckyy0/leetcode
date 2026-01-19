# 295. Find Median from Data Stream / Tìm Trung Vị từ Luồng Dữ Liệu

## Problem Description / Mô tả bài toán
The **median** is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
**Trung vị** là giá trị ở giữa trong một danh sách số nguyên được sắp xếp. Nếu kích thước của danh sách là chẵn, không có giá trị ở giữa và trung vị là trung bình cộng của hai giá trị ở giữa.

- For example, for `arr = [2,3,4]`, the median is `3`.
- For example, for `arr = [2,3]`, the median is `(2 + 3) / 2 = 2.5`.

Implement the `MedianFinder` class:
- `MedianFinder()` initializes the `MedianFinder` object.
- `void addNum(int num)` adds the integer `num` to the data structure.
- `double findMedian()` returns the median of all elements so far. Answers within `10^-5` of the actual answer will be accepted.

### Example 1:
```text
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]
```

## Constraints / Ràng buộc
- `-10^5 <= num <= 10^5`
- There will be at least one element in the data structure before calling `findMedian`.
- At most `5 * 10^4` calls will be made to `addNum` and `findMedian`.

**Follow up**:
- If all integer numbers from the stream are between 0 and 100, how would you optimize it? (Bucket/Counting Sort).
- If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it? (Buckets + Heaps for outliers).

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Heaps / Hai Đống
We want to maintain the stream in two halves:
- **Low Half** (Max Heap): Stores smaller numbers. Top is largest of smalls.
- **High Half** (Min Heap): Stores larger numbers. Top is smallest of larges.

Invariant:
1.  `size(Low) == size(High)` OR `size(Low) == size(High) + 1`. (Low can hold 1 extra).
2.  `max(Low) <= min(High)`.

**Algorithm**:
- `addNum(num)`:
    - Add to `Low` (MaxHeap).
    - Move largest of `Low` to `High` (MinHeap) to keep order.
    - If `size(High) > size(Low)`, move smallest of `High` back to `Low` (Balance sizes).
- `findMedian()`:
    - If `size(Low) > size(High)`, return `Low.peek()`.
    - If equal, return `(Low.peek() + High.peek()) / 2.0`.

### Complexity / Độ phức tạp
- **Time**: `addNum` O(log N), `findMedian` O(1).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Two Heaps

**Edge Cases**:
1.  Empty? Problem says checked.
2.  Negative numbers? PriorityQueue handles integers fine.

---
