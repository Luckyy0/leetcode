# Analysis for Max Sum of Rectangle No Larger Than K
# *Phân tích cho bài toán Tổng Hình chữ nhật Lớn nhất không vượt quá K*

## 1. Problem Essence & 2D Prefix Sums
## *1. Bản chất vấn đề & Tổng Tiền tố 2D*

### The Challenge
### *Thách thức*
Finding a rectangle subgrid with sum $S \le k$.
Standard "Max Subarray Sum" (Kadane's) is $O(N)$, but that is for *unconstrained* maximum. For $S \le k$, we need a more precise search.

### Strategy: Dimension Reduction (Row-based compression)
### *Chiến lược: Giảm chiều (Nén dựa trên Hàng)*
1.  Assume we fix two row boundaries `r1` and `r2`.
2.  Compress the elements between `r1` and `r2` into a single 1D array where each element is the sum of elements in that column between `r1` and `r2`.
3.  The problem reduces to: "Find a subarray sum $\le k$ in a 1D array".
4.  **1D Problem:** Find $currSum - prevSum \le k \implies prevSum \ge currSum - k$.
    - Use a **TreeSet** to store all `prevSum` values seen so far.
    - `set.ceiling(currSum - k)` gives the smallest sum $\ge currSum - k$ in $O(\log N)$.

---

## 2. Approach: Row Compression + TreeSet
## *2. Hướng tiếp cận: Nén Hàng + TreeSet*

### Logic
### *Logic*
Iterate through all pairs of rows $(i, j)$. For each pair, maintain a running column sum array. Then use the TreeSet method for the 1D problem.
Optimization: If $M > N$, compress rows. If $N > M$, compress columns. This ensures we iterate fewer times in the outer loops.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **TreeSet Efficiency:** $O(\log N)$ search for the prefix sum boundary.
    *Hiệu quả TreeSet: Tìm kiếm O(log N) cho biên tổng tiền tố.*
*   **Dimensional Flex:** Handles both tall and wide matrices efficiently.
    *Linh hoạt chiều: Xử lý hiệu quả cả ma trận cao và rộng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(min(M, N)^2 \cdot max(M, N) \log max(M, N))$.
    *Độ phức tạp thời gian: $O(min(M,N)^2 \cdot max(M,N) \log max(M,N))$.*
*   **Space Complexity:** $O(max(M, N))$.
    *Độ phức tạp không gian: $O(max(M, N))$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[1,0,1], [0,-2,3]], k=2`
1. Fix rows 0 to 1.
2. Compressed array: `[1+0, 0+(-2), 1+3]` = `[1, -2, 4]`.
3. Prefix sums: `0, 1, -1, 3`.
4. At prefix 3: Need $prevSum \ge 3 - 2 = 1$.
5. `set.ceiling(1)` is 1. (Sum = 3 - 1 = 2).
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

TreeSet based 1D search combined with row/col compression.
*Tìm kiếm 1D dựa trên TreeSet kết hợp với nén hàng/cột.*
---
*Đôi khi chúng ta cần phải thu hẹp tầm nhìn (row compression) để thấy rõ những quy luật ẩn giấu. Việc đặt ra những giới hạn (k condition) đòi hỏi một sự tìm kiếm có chọn lọc (TreeSet) thay vì chỉ đuổi theo những giá trị lớn nhất.*
Sometimes we need to narrow our vision (row compression) to see hidden patterns. Setting limits (k condition) requires selective searching (TreeSet) rather than just chasing the largest values.
