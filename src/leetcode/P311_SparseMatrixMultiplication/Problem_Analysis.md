# 311. Sparse Matrix Multiplication / Nhân Ma Trận Thưa

## Problem Description / Mô tả bài toán
Given two sparse matrices `mat1` of size `m x k` and `mat2` of size `k x n`, return the result of `mat1 x mat2`. You may assume that multiplication is always possible.
Cho hai ma trận thưa `mat1` kích thước `m x k` và `mat2` kích thước `k x n`, trả về kết quả của `mat1 x mat2`. Bạn có thể giả định rằng phép nhân luôn có thể thực hiện được.

### Example 1:
```text
Input: mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
Output: [[7,0,0],[-7,0,3]]
```

### Example 2:
```text
Input: mat1 = [[0]], mat2 = [[0]]
Output: [[0]]
```

## Constraints / Ràng buộc
- `m == mat1.length`
- `k == mat1[i].length == mat2.length`
- `n == mat2[i].length`
- `1 <= m, n, k <= 100`
- `-100 <= mat1[i][j], mat2[i][j] <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Standard Multiplication with Optimization / Nhân Tiêu Chuẩn với Tối Ưu Hóa
Standard Matrix Multiplication `C` of `A` (MxK) and `B` (KxN):
`C[i][j] = Sum(A[i][p] * B[p][j])` for `p` from 0 to K-1.
Time: `O(M * N * K)`.

**Sparse Optimization**:
Since matrices are sparse (many zeros), we can skip calculations if `A[i][p] == 0`.
Logic:
Iterate `i` from 0 to M-1.
  Iterate `k` from 0 to K-1.
    If `A[i][k] != 0`:
      Iterate `j` from 0 to N-1.
         If `B[k][j] != 0`:
           `C[i][j] += A[i][k] * B[k][j]`.

This changes complexity to roughly `O(M * N * K * Density)`.
Even better optimization: Pre-process B to store non-zero indices for each row `k`. Or simply check `B[k][j]`.

### CSR (Compressed Sparse Row)
For very sparse limit, we can convert to CSR format `(value, col_index)` lists for each row.
Given constraints (100x100), simple "check zero" optimization is sufficient and optimal enough.

### Complexity / Độ phức tạp
- **Time**: `O(M * K * N)` worst case, but efficient for sparse.
- **Space**: `O(M * N)` result.

---

## Analysis / Phân tích

### Approach: Zero Checking Loop

**Algorithm**:
1.  Initialize `res[m][n]`.
2.  Loop `i` (0..m), `k` (0..K).
3.  If `mat1[i][k] != 0`:
    - Loop `j` (0..n).
    - `res[i][j] += mat1[i][k] * mat2[k][j]`.
    - (Can also check if `mat2[k][j] != 0` to skip addition of 0).

---
