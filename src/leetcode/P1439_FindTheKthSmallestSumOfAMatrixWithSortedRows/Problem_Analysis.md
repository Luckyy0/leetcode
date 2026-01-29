# 1439. Find the Kth Smallest Sum of a Matrix With Sorted Rows / Tìm Tổng Nhỏ nhất Thứ K của Ma trận với Các hàng Đã sắp xếp

## Problem Description / Mô tả bài toán
Matrix `mat` (m x n). Each row sorted.
Pick one from each row. Sum. K-th smallest sum.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iterative Merging (Reduce with K-th Smallest Pair Sum)
Reduce problem:
Row 1 + Row 2 -> `K` smallest sums.
(Row 1+2) + Row 3 -> `K` smallest sums.
...
Merge two sorted arrays to find top K sums?
If arrays size `k` and `n`.
Use Min-Heap to generate sums.
Since we need `K`-th smallest overall, keep only `K` smallest at each step to avoid explosion.
Because K <= 200, this is very fast. `m <= 40`.
Step:
`currSums` = `mat[0]`. Keep top K (slice).
For each row `i` in `1..m-1`:
  `newSums` = generate all pairs sum (`currSums` x `mat[i]`).
  Keep smallest `K`. `currSums = newSums`.

### Complexity / Độ phức tạp
- **Time**: O(M * K * N * log(K*N))? Or O(M * K * log K) with optimization.
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Merge Row by Row
Initialize `prevRow` with the elements of the first row (keep only min(K, n) elements).
Iterate through remaining rows. For each row, combine `prevRow` with `currentRow` to form all possible sums. Store sums in a list/priority queue, pick the smallest K.
This keeps the candidate pool small.
Khởi tạo `prevRow` với các phần tử của hàng đầu tiên (chỉ giữ lại các phần tử min(K, n)).
Lặp qua các hàng còn lại. Đối với mỗi hàng, kết hợp `prevRow` với `currentRow` để tạo thành tất cả các tổng có thể. Lưu trữ tổng trong danh sách/hàng đợi ưu tiên, chọn K nhỏ nhất.

---
