# 986. Interval List Intersections / Giao của các Danh sách Khoảng

## Problem Description / Mô tả bài toán
You are given two lists of closed intervals. Return the intersection of these two interval lists.
Bạn được cho hai danh sách các khoảng đóng. Hãy trả về phần giao của hai danh sách khoảng này.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Intersection Logic / Hai con trỏ / Logic phần giao
Algorithm:
1. `i = 0`, `j = 0`.
2. While `i < n` and `j < m`:
   - Find start: `s = max(list1[i].start, list2[j].start)`.
   - Find end: `e = min(list1[i].end, list2[j].end)`.
   - If `s <= e`, add `[s, e]` to results.
   - Advance the pointer of the interval that ends earlier.

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(N + M) for results.

---

## Analysis / Phân tích

### Approach: Synchronous Boundary Sweep
Traverse both lists simultaneously. At each step, identify the overlapping segment between the current two intervals by taking the latest start and the earliest end. Move forward by discarding the interval that concludes first, as it cannot possibly intersect with any future intervals.
Duyệt qua cả hai danh sách đồng thời. Tại mỗi bước, xác định đoạn chồng chéo giữa hai khoảng hiện tại bằng cách lấy điểm bắt đầu muộn nhất và điểm kết thúc sớm nhất. Tiến lên bằng cách loại bỏ khoảng kết thúc trước, vì nó không thể giao với bất kỳ khoảng nào trong tương lai.

---
