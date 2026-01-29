# 1253. Reconstruct a 2-Row Binary Matrix / Tái tạo Ma trận Nhị phân 2 Hàng

## Problem Description / Mô tả bài toán
Given `upper` (sum of row 0), `lower` (sum of row 1), and `colsum` array (sum of each column).
Reconstruct binary matrix. Elements 0 or 1.
If impossible return empty.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach / Cách tiếp cận Tham lam
Iterate columns.
- `colsum[i] == 2`: Must be 1 in both rows. Decrement `upper`, `lower`.
- `colsum[i] == 0`: Must be 0 in both rows.
- `colsum[i] == 1`: Must be 1 in one row. Prefer row with larger remaining sum requirement?
  Yes, if `upper > lower`, give to upper. Or just check if `upper > 0`?
  Actually, first pass handle all 2s.
  Second pass handle all 1s: give to `upper` if `upper > 0`, else `lower`.
  Finally check if `upper == 0` and `lower == 0`.
Constraint: total sum must match `upper + lower`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) output.

---

## Analysis / Phân tích

### Approach: Greedy Assignment
Process columns based on `colsum[i]`.
1. If `colsum[i] == 2`, both `matrix[0][i]` and `matrix[1][i]` must be 1. Decrement `upper` and `lower`.
2. If `colsum[i] == 0`, both are 0.
3. If `colsum[i] == 1`, assign to `upper` row if `upper > 0`, otherwise to `lower`. Decrement respective counter.
After processing all columns, verify if `upper == 0` and `lower == 0`. If not (or if counters went negative during process), return empty.
Xử lý các cột dựa trên `colsum[i]`.
1. Nếu `colsum[i] == 2`, cả `matrix[0][i]` và `matrix[1][i]` đều phải là 1. Giảm `upper` và `lower`.
2. Nếu `colsum[i] == 0`, cả hai đều là 0.
3. Nếu `colsum[i] == 1`, gán cho hàng `upper` nếu `upper > 0`, ngược lại cho `lower`. Giảm bộ đếm tương ứng.
Sau khi xử lý tất cả các cột, hãy xác minh xem `upper == 0` và `lower == 0` hay không. Nếu không (hoặc nếu bộ đếm bị âm trong quá trình), hãy trả về rỗng.

---
