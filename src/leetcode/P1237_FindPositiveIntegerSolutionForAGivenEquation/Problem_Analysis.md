# 1237. Find Positive Integer Solution for a Given Equation / Tìm Nghiệm Nguyên dương cho Một Phương trình đã Cho

## Problem Description / Mô tả bài toán
Given a function `f(x, y)` which is strictly increasing in `x` and `y`.
Find all pairs `(x, y)` such that `f(x, y) == z`.
1 <= x, y <= 1000.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers (Saddleback Search) / Hai con trỏ (Tìm kiếm Saddleback)
Since `f` increases in both args.
Start `x = 1`, `y = 1000`.
- If `f(x, y) == z`: add `(x, y)`, `x++`, `y--`. (Wait, if x increases, y must decrease to keep sum same. If multiple y? No, strictly increasing means unique y for fixed x).
- If `f(x, y) > z`: `y--` (too big).
- If `f(x, y) < z`: `x++` (too small).

### Complexity / Độ phức tạp
- **Time**: O(X + Y). Max 2000 steps.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers on Monotonic Function
The function `f(x, y)` is monotonic. This is structurally similar to searching in a sorted 2D matrix. Start with `x` at minimum (1) and `y` at maximum (1000). If `f(x, y) > z`, decrement `y` to reduce the value. If `f(x, y) < z`, increment `x` to increase the value. If `f(x, y) == z`, record the pair and move both pointers (e.g., `x++`, `y--`) since `f` is strictly increasing.
Hàm `f(x, y)` là đơn điệu. Điều này có cấu trúc tương tự như tìm kiếm trong ma trận 2D đã sắp xếp. Bắt đầu với `x` ở mức tối thiểu (1) và `y` ở mức tối đa (1000). Nếu `f(x, y) > z`, hãy giảm `y` để giảm giá trị. Nếu `f(x, y) < z`, hãy tăng `x` để tăng giá trị. Nếu `f(x, y) == z`, hãy ghi lại cặp và di chuyển cả hai con trỏ (ví dụ: `x++`, `y--`) vì `f` tăng nghiêm ngặt.

---
