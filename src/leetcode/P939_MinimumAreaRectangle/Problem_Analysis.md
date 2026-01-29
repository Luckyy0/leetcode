# 939. Minimum Area Rectangle / Diện tích Hình chữ nhật Nhỏ nhất

## Problem Description / Mô tả bài toán
Given a set of points in the XY plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes.
Cho một tập hợp các điểm trong mặt phẳng XY, hãy giao diện tích nhỏ nhất của một hình chữ nhật được tạo thành từ các điểm này, với các cạnh song song với trục X và Y.

If no such rectangle exists, return 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Diagonal Pair Matching / Khớp cặp Đường chéo
Any rectangle with sides parallel to axes is uniquely defined by two of its diagonal points `(x1, y1)` and `(x2, y2)`.
Bất kỳ hình chữ nhật nào có các cạnh song song với các trục đều được xác định duy nhất bởi hai điểm chéo của nó `(x1, y1)` và `(x2, y2)`.

Algorithm:
1. Store all points in a `Set` for O(1) existence check.
2. Iterate through all pairs of points `(x1, y1)` and `(x2, y2)`:
   - If `x1 != x2` and `y1 != y2` (forming a diagonal):
     - Check if points `(x1, y2)` and `(x2, y1)` also exist in the set.
     - If they exist, calculate area: `|x1 - x2| * |y1 - y2|`.
     - Update `minArea`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Diagonal Completion check
Treat every pair of points as a potential diagonal. By verifying the presence of the corresponding "missing" corners in the dataset, we identify valid axis-aligned rectangles and calculate their footprints efficiently.
Coi mọi cặp điểm như một đường chéo tiềm năng. Bằng cách xác minh sự hiện diện của các góc "còn thiếu" tương ứng trong tập dữ liệu, chúng ta xác định được các hình chữ nhật thẳng hàng với trục hợp lệ và tính toán diện tích của chúng một cách hiệu quả.

---
