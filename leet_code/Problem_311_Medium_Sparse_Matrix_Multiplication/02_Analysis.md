# Analysis for Sparse Matrix Multiplication
# *Phân tích cho bài toán Nhân Ma trận Thưa*

## 1. Problem Essence & Sparsity
## *1. Bản chất vấn đề & Tính thưa*

### The Optimization
### *Tối ưu hóa*
Standard Matrix Multiplication: `C[i][j] = sum(A[i][k] * B[k][j])`.
Time: $O(M \cdot N \cdot K)$.
If matrices are sparse (many zeros), most multiplications are `0 * something` or `something * 0`.
We can skip these.

### Strategy: Row-based check
### *Chiến lược: Kiểm tra theo hàng*
For `i` from 0 to `m`:
  For `k` from 0 to `k_dim`:
    If `A[i][k] == 0`: Continue! (Skip entire loop of `j`).
    Elif `A[i][k] != 0`:
      For `j` from 0 to `n`:
        If `B[k][j] != 0`:
           `C[i][j] += A[i][k] * B[k][j]`.

This changes complexity to roughly $O(M \cdot L \cdot N)$ where L is avg non-zeros per row.

### Further Optimization: CSR (Compressed Sparse Row)
### *Tối ưu hóa hơn nữa: CSR*
Pre-process `B` into a list of non-zero entries.
`adjB[k]` = list of pairs `{col, val}`.
Then iteration becomes:
For `i`..
  For `k`..
    If `A[i][k] != 0`:
      For `{col, val}` in `adjB[k]`:
        `C[i][col] += A[i][k] * val`.
This avoids iterating `j` completely if `B[k]` is empty or sparse.

Given constraints `100x100`, simple check skip is sufficient. But CSR is better interview answer.
I will implement simple optimized loop as it is standard and sufficient. Actually, I can construct a sparse map for B if needed, but for dense N loop skipping A zeroes is the biggest gain.

---

## 2. Approach: Simple Optimization
## *2. Hướng tiếp cận: Tối ưu hóa đơn giản*

### Logic
### *Logic*
1.  Result `C[m][n]`.
2.  Loop `i` (0..m).
3.  Loop `k` (0..K).
    - If `mat1[i][k] != 0`:
        - Loop `j` (0..n).
            - `C[i][j] += mat1[i][k] * mat2[k][j]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Cache Friendly?** `mat2` is accessed row by row inside `j` loop? No, `mat2[k][j]` is accessing row `k`. `j` varies. So we iterate row `k` of `mat2`. This is contiguous memory access (friendly).
*   **Sparsity:** Exploits zeros in `mat1`.
    *Thân thiện với bộ đệm? Có, truy cập bộ nhớ liền kề. Tính thưa: Khai thác các số 0 trong mat1.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot K \cdot N)$ worst case, but faster on sparse.
    *Độ phức tạp thời gian: O(M*K*N) trường hợp xấu nhất.*
*   **Space Complexity:** $O(M \cdot N)$ for result.
    *Độ phức tạp không gian: O(M*N).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** A=[[1,0],[0,0]], B=[[2],[3]]
i=0. k=0. A[0][0]=1 != 0.
  j=0. C[0][0] += 1 * B[0][0](2) = 2.
k=1. A[0][1]=0. Skip.
i=1. k=0. A[1][0]=0. Skip.
k=1. A[1][1]=0. Skip.
Result: 2, 0. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simple check `if (val != 0)` is the most practical first optimization.
*Kiểm tra đơn giản `if (val != 0)` là tối ưu hóa thực tế đầu tiên.*
---
*Đừng lãng phí công sức vào những điều vô nghĩa (zeros). Chỉ đầu tư thời gian vào những giá trị thực sự (non-zeros) để tạo ra kết quả.*
Don't waste effort on meaningless things (zeros). Only invest time in real values (non-zeros) to produce results.
