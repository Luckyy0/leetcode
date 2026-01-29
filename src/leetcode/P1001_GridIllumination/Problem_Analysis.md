# 1001. Grid Illumination / Chiếu sáng Lưới

## Problem Description / Mô tả bài toán
There is a 2D `grid` of size `n x n`. You are given an array `lamps` where `lamps[i] = [row_i, col_i]` indicates that the lamp at that position is on.
Có một `lưới` 2D kích thước `n x n`. Bạn được cho một mảng `lamps` trong đó `lamps[i] = [row_i, col_i]` cho biết đèn tại vị trí đó đang bật.

A lamp illuminates its row, its column, and its two diagonals.
Một chiếc đèn chiếu sáng hàng, cột và hai đường chéo của nó.

You are also given `queries`, where `queries[j] = [row_j, col_j]`. For each query:
1. Determine if the cell `[row_j, col_j]` is illuminated (1 if yes, 0 if no).
2. After answering, turn off any lamp that is in the cell `[row_j, col_j]` or adjacent to it (8 neighbors + center).

Return an array of answers.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap Counter / Bộ đếm HashMap
The grid size `n` can be up to $10^9$, so we cannot use a 2D array.
Kích thước lưới `n` có thể lên tới $10^9$, vì vậy chúng ta không thể sử dụng mảng 2D.

However, the number of lamps is relatively small ($2 \times 10^4$). We can store the count of lamps affecting each row, column, and diagonal.
Tuy nhiên, số lượng đèn tương đối nhỏ ($2 \times 10^4$). Chúng ta có thể lưu trữ số lượng đèn ảnh hưởng đến từng hàng, cột và đường chéo.

For a cell `(r, c)`:
- Row: `r`
- Column: `c`
- Main Diagonal: `r - c`
- Anti Diagonal: `r + c`

Algorithm:
1. `Map<Integer, Integer>` for rows, cols, diag, anti-diag counts.
2. `Set<Long>` to store exact lamp positions (to handle turning off existing lamps).
3. For query `(r, c)`:
   - Check if `row.get(r) > 0 || col.get(c) > 0 || ...`
   - Iterate 3x3 area around `(r, c)`. If a lamp exists there (check Set), remove it and decrement counters.

### Complexity / Độ phức tạp
- **Time**: O(L + Q), where L is number of lamps, Q is number of queries. constant time per query (checking 9 cells).
- **Space**: O(L).

---

## Analysis / Phân tích

### Approach: Sparse Influence Mapping
Track the illumination influence using four separate hash maps (one for each axis/diagonal type). Since the grid is huge but sparse, counting overlapping beam sources allows for O(1) query validation. Updates are handled by decrementing these localized counters when lamps are extinguished.
Theo dõi ảnh hưởng chiếu sáng bằng cách sử dụng bốn bản đồ băm riêng biệt (mỗi bản đồ cho mỗi loại trục/đường chéo). Vì lưới rất lớn nhưng thưa thớt, việc đếm các nguồn chùm tia chồng chéo cho phép xác thực truy vấn trong O(1). Các cập nhật được xử lý bằng cách giảm các bộ đếm cục bộ này khi đèn bị tắt.

---
