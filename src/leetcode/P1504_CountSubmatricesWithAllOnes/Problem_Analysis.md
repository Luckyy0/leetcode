# 1504. Count Submatrices With All Ones / Đếm Ma trận con Với Tất cả Số Một

## Problem Description / Mô tả bài toán
Binary Matrix `mat`. Count submatrices with all ones.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Histogram / Monotonic Stack
For each row `i`, construct `height[j]` = consecutive ones above `(i, j)`.
`height[j] = (mat[i][j] == 0) ? 0 : height[j] (from prev row) + 1`.
Problem reduces to: Count submatrices in a histogram (for each row).
For a histogram `h`, total rectangles?
For each bar `j`: count rectangles ending at `j`.
If `h[j]` > `h[j-1]`: rectangles adds `h[j] + rects[j-1]`?. No.
Use monotonic stack to find `left` bound where `h[k] < h[j]`.
`count[j] = count[prev_smaller] + h[j] * (j - prev_smaller)`.
Sum `count[j]` for all `j`.
Do this for each row.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Row Compression + Stack
Iterate rows. Compute heights.
For each row, use monotonic stack to calculate rectangles in histogram.
Total sum is answer.
Lặp lại các hàng. Tính toán độ cao.
Đối với mỗi hàng, sử dụng ngăn xếp đơn điệu để tính toán hình chữ nhật trong biểu đồ.
Tổng số là câu trả lời.

---
