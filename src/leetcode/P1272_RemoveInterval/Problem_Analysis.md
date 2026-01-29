# 1272. Remove Interval / Xóa Khoảng

## Problem Description / Mô tả bài toán
Set of pairwise disjoint intervals (sorted). Remove a `toBeRemoved` interval.
Return sorted list of remaining intervals.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Intersection / Giao điểm Khoảng
For each interval `[start, end]` in input:
1. No overlap with `toBeRemoved`: Add to result.
2. Overlap:
   - Part before `toBeRemoved`: `[start, min(end, removeStart)]` if valid.
   - Part after `toBeRemoved`: `[max(start, removeEnd), end]` if valid.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) output.

---

## Analysis / Phân tích

### Approach: Linear Scan
Iterate through the given sorted intervals. For each interval `curr`, check for overlap with `toBeRemoved`.
- If `curr.end <= toBeRemoved.start` or `curr.start >= toBeRemoved.end`: No removal inside this interval (keep fully).
- Else: 'Cut' the interval.
  - Left piece: `[curr.start, toBeRemoved.start]` if `curr.start < toBeRemoved.start`.
  - Right piece: `[toBeRemoved.end, curr.end]` if `curr.end > toBeRemoved.end`.
This handles full containment, partial overlap, and complete removal correctly.
Duyệt qua các khoảng được sắp xếp đã cho. Đối với mỗi khoảng `curr`, kiểm tra sự chồng chéo với `toBeRemoved`.
- Nếu `curr.end <= toBeRemoved.start` hoặc `curr.start >= toBeRemoved.end`: Không xóa bên trong khoảng này (giữ nguyên hoàn toàn).
- Khác: 'Cắt' khoảng.
  - Phần bên trái: `[curr.start, toBeRemoved.start]` nếu `curr.start < toBeRemoved.start`.
  - Phần bên phải: `[toBeRemoved.end, curr.end]` nếu `curr.end > toBeRemoved.end`.
Điều này xử lý việc chứa hoàn toàn, chồng chéo một phần và xóa hoàn toàn một cách chính xác.

---
