# Analysis for Data Stream as Disjoint Intervals
# *Phân tích cho bài toán Luồng Dữ liệu dưới dạng các Khoảng Rời rạc*

## 1. Problem Essence & Sorted Intervals
## *1. Bản chất vấn đề & Các khoảng đã sắp xếp*

### The Challenge
### *Thách thức*
Maintaining a list of non-overlapping intervals in sorted order as points are added dynamically. Efficiency in searching for neighbors and merging is key.

### Strategy: TreeMap
### *Chiến lược: TreeMap*
Use a `TreeMap<Integer, int[]>` to store intervals, mapping `start -> [start, end]`.
`TreeMap` provides `floorKey` and `higherKey` in $O(\log N)$, which are perfect for finding the interval to the left or right of a new value.

### Merging Cases for `val`:
### *Các trường hợp Hợp nhất cho `val`:*
1.  **Merge Left and Right:** `left.end + 1 == val` AND `right.start - 1 == val`.
    Result: `[left.start, right.end]`. Remove both, add new.
2.  **Merge Left:** `left.end + 1 == val`.
    Result: `[left.start, val]`. Update end.
3.  **Merge Right:** `right.start - 1 == val`.
    Result: `[val, right.end]`. Remove right, add new.
4.  **Already Covered:** `left.end >= val`.
    No change.
5.  **New Isolated Interval:** None of the above.
    Add `[val, val]`.

---

## 2. Approach: TreeMap with Boundary Search
## *2. Hướng tiếp cận: TreeMap với Tìm kiếm Biên*

### Logic
### *Logic*
(See Merging Cases above). Using `TreeMap` ensures that intervals are always sorted by their start values, making `getIntervals` simple.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Efficiency:** $O(\log N)$ for `addNum`.
    *Hiệu quả Logarithm: $O(\log N)$ cho `addNum`.*
*   **Sorted Integrity:** Inherently maintains order.
    *Tính nhất quán sắp xếp: Vốn đã duy trì thứ tự.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `addNum`: $O(\log N)$.
    - `getIntervals`: $O(N)$ where N is number of intervals.
    *Độ phức tạp thời gian: $O(\log N)$ cho addNum, $O(N)$ cho getIntervals.*
*   **Space Complexity:** $O(N)$ total number of intervals stored.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Operation:** add 2 to `{ [1,1], [3,3] }`
1. `floorKey(2)` is 1. `left = [1, 1]`.
2. `higherKey(2)` is 3. `right = [3, 3]`.
3. Check: `1.end + 1 == 2` (Yes) AND `3.start - 1 == 2` (Yes).
4. Merge: Remove 1, Remove 3. Add `[1, 3]`.
Result: `{ [1, 3] }`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

TreeMap is the standard way to handle disjoint intervals dynamically.
*TreeMap là cách tiêu chuẩn để xử lý các khoảng rời rạc một cách năng động.*
---
*Cuộc sống là một chuỗi các luồng dữ liệu (data stream). Những mảnh vụn (individual values) ban đầu có vẻ rời rạc, nhưng khi ta tìm thấy sự kết nối (merging), chúng sẽ tạo nên những khoảng thời gian (intervals) trọn vẹn và ý nghĩa.*
Life is a series of data streams. Individual pieces (individual values) might seem disjointed at first, but when we find the connection (merging), they create complete and meaningful time intervals.
