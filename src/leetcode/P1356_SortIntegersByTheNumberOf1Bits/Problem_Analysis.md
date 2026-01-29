# 1356. Sort Integers by The Number of 1 Bits / Sắp xếp Các Số nguyên theo Số lượng Bit 1

## Problem Description / Mô tả bài toán
Array `arr`. Sort by number of 1 bits.
Tie-break: by value ascending.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Counting and Sorting
Use `Integer.bitCount(n)` or custom function.
Sort with custom comparator.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N) or O(log N).

---

## Analysis / Phân tích

### Approach: Custom Sort
Convert `int[]` to `Integer[]` to use `Arrays.sort` with a comparator.
Comparator logic:
1. `Integer.bitCount(a)` vs `Integer.bitCount(b)`.
2. If equal, compare `a` vs `b`.
Finally convert back to `int[]`.
Chuyển đổi `int[]` sang `Integer[]` để sử dụng `Arrays.sort` với một bộ so sánh.
Logic so sánh:
1. `Integer.bitCount(a)` so với `Integer.bitCount(b)`.
2. Nếu bằng nhau, so sánh `a` so với `b`.
Cuối cùng chuyển đổi lại thành `int[]`.

---
