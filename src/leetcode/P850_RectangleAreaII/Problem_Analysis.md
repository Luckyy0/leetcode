# 850. Rectangle Area II / Diện tích Hình chữ nhật II

## Problem Description / Mô tả bài toán
You are given a list of `rectangles`. Each rectangle is defined by `[x1, y1, x2, y2]`.
Bạn được cấp một danh sách các hình chữ nhật (`rectangles`). Mỗi hình chữ nhật được xác định bởi `[x1, y1, x2, y2]`.

Return the total area covered by all rectangles in the plane. Since the answer may be too large, return it **modulo 10^9 + 7**.
Trả về tổng diện tích được bao phủ bởi tất cả các hình chữ nhật trong mặt phẳng. Vì câu trả lời có thể quá lớn, hãy trả về kết quả theo **modulo 10^9 + 7**.

Any overlapping region should only be counted once.
Bất kỳ vùng chồng lấn nào cũng chỉ được tính một lần.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Line Sweep Algorithm / Thuật toán Quét đường
Coordinate compression or Line Sweep.
Nén tọa độ hoặc Quét đường.

Algorithm (Line Sweep):
1. Collect all unique X-coordinates and sort them.
2. These X-coordinates divide the plane into vertical strips.
3. For each strip `(x_i, x_{i+1})`:
   - Find all rectangles that cover this X-range.
   - For these rectangles, project their Y-ranges.
   - Calculate the total covered Y-length (similar to Merge Intervals).
   - Area += `stripWidth * totalYLength`.

### Complexity / Độ phức tạp
- **Time**: O(N^2 log N) or O(N^2).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Strip-based Summation
Segment the entire plane into vertical slices based on the horizontal boundaries of the rectangles. Within each slice, the coverage problem becomes 1D (segments on a line), which is significantly easier to resolve.
Phân đoạn toàn bộ mặt phẳng thành các lát dọc dựa trên ranh giới ngang của các hình chữ nhật. Trong mỗi lát, bài toán bao phủ trở thành 1 chiều (các đoạn trên một đường thẳng), điều này dễ giải quyết hơn đáng kể.

---
