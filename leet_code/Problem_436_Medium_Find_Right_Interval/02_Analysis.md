# Analysis for Find Right Interval
# *Phân tích cho bài toán Tìm Khoảng bên Phải*

## 1. Problem Essence & Binary Search
## *1. Bản chất vấn đề & Tìm kiếm Nhị phân*

### The Challenge
### *Thách thức*
For each interval, find another interval whose starting point is greater than or equal to the current interval's end point, specifically the one with the smallest such start point. Since $N = 2 \times 10^4$, a brute force $O(N^2)$ might be too slow. We need a way to search for the "smallest start >= end" efficiently.

### Strategy: TreeMap or Sorted Search
### *Chiến lược: TreeMap hoặc Tìm kiếm có sắp xếp*

1.  **Map Starts to Indices:** Store all `start` positions and their corresponding original indices in a way that allows ordered lookups. A `TreeMap<Integer, Integer>` in Java is perfect for this.
2.  **Lookup:** For each interval `[start, end]`:
    - Use `treeMap.ceilingKey(end)` to find the smallest key (start value) that is $\ge end$.
    - If found, retrieve the index from the map.
    - If not found, result is -1.

---

## 2. Approach: Ordered Mapping
## *2. Hướng tiếp cận: Ánh xạ Thứ tự*

### Logic
### *Logic*
(See above). The `ceilingKey` and `ceilingEntry` methods in `TreeMap` provide $O(\log N)$ search time. This ensures the total time complexity is $O(N \log N)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficient Lookups:** Reduces $O(N^2)$ search to $O(N \log N)$.
    *Tra cứu hiệu quả: Giảm việc tìm kiếm từ O(N^2) xuống O(N log N).*
*   **Intuitive API:** Java's `TreeMap` handles the ordering and binary search logic internally.
    *API trực quan: TreeMap của Java xử lý logic sắp xếp và tìm kiếm nhị phân nội bộ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$, where $N$ is the number of intervals ($N \log N$ for building the map, $N \log N$ for $N$ lookups).
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ to store the map.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[3,4], [2,3], [1,2]]`
1. Build `TreeMap`: `{1:2, 2:1, 3:0}` (Start:Index)
2. Interval `[3,4]`: `ceilingKey(4)` $\to$ null. `-1`.
3. Interval `[2,3]`: `ceilingKey(3)` $\to$ 3 (index 0). `0`.
4. Interval `[1,2]`: `ceilingKey(2)` $\to$ 2 (index 1). `1`.
Result: `[-1, 0, 1]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

TreeMap with `ceilingKey` for optimal search.
*TreeMap với ceilingKey để tìm kiếm tối ưu.*
---
*Tìm kiếm một "khoảng bên phải" (right interval) cũng giống như việc tìm kiếm một bước đệm tiếp theo trong sự nghiệp. Ta cần một điểm bắt đầu mới (start) đủ lớn để bao quát lấy những gì ta vừa kết thúc (end), nhưng cũng phải đủ gần (smallest) để không lãng phí tài nguyên. Bằng cách sắp xếp các cơ hội (TreeMap), ta có thể tìm thấy đúng hướng đi chỉ trong một cái liếc nhìn (binary search).*
Searching for a "right interval" (right interval) is like searching for a next stepping stone in a career. We need a new starting point (start) large enough to cover what we just finished (end), but also close enough (smallest) not to waste resources. By organizing opportunities (TreeMap), we can find the right direction in just one glance (binary search).
