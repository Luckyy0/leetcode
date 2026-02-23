# Analysis for Ugly Number II
# *Phân tích cho bài toán Số xấu II*

## 1. Problem Essence & Merge Pattern
## *1. Bản chất vấn đề & Mẫu hợp nhất*

### The Generation
### *Sự sinh ra*
We want to generate the sequence `1, 2, 3, 4, 5, 6, 8, ...` in order.
Every ugly number is derived from a smaller ugly number multiplied by 2, 3, or 5.
$U_k \in \{ U_i \times 2, U_j \times 3, U_m \times 5 \}$ for some indices $i, j, m < k$.

### Strategy: Merging 3 Sorted Lists
### *Chiến lược: Hợp nhất 3 danh sách đã sắp xếp*
Imagine 3 conceptual lists:
- L2: `1*2, 2*2, 3*2, 4*2, 5*2, ...`
- L3: `1*3, 2*3, 3*3, 4*3, 5*3, ...`
- L5: `1*5, 2*5, 3*5, 4*5, 5*5, ...`
(Actually multiply the *ugly sequence* so far).
- L2: `U[0]*2, U[1]*2, ...`
- L3: `U[0]*3, U[1]*3, ...`
- L5: `U[0]*5, U[1]*5, ...`

We maintain 3 pointers `p2, p3, p5`, all starting at 0.
Next ugly number is `min(U[p2]*2, U[p3]*3, U[p5]*5)`.
Update the pointer(s) that produced the min value. Note: If multiple produce the same min (e.g., $2 \times 3 = 6$ and $3 \times 2 = 6$), increment BOTH pointers to skip duplicates.

---

## 2. Approach: Dynamic Programming (Three Pointers)
## *2. Hướng tiếp cận: Quy hoạch động (Ba con trỏ)*

### Logic
### *Logic*
1.  Array `dp` of size `n`. `dp[0] = 1`.
2.  `p2 = 0, p3 = 0, p5 = 0`.
3.  Loop `i` from 1 to `n-1`:
    - `next2 = dp[p2] * 2`
    - `next3 = dp[p3] * 3`
    - `next5 = dp[p5] * 5`
    - `dp[i] = min(next2, next3, next5)`
    - If `dp[i] == next2`: `p2++`
    - If `dp[i] == next3`: `p3++`
    - If `dp[i] == next5`: `p5++`
4.  Return `dp[n-1]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Ordered Generation:** Guarantees strictly increasing order without sorting. Constant time to pick next.
    *Sinh có thứ tự: Đảm bảo thứ tự tăng dần nghiêm ngặt mà không cần sắp xếp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ to store sequence.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

`n=10`.
`dp=[1]`. p2=0, p3=0, p5=0.
1.  Min(2, 3, 5) = 2. `dp=[1, 2]`. `p2++` (1).
2.  Min(4, 3, 5) = 3. `dp=[1, 2, 3]`. `p3++` (1).
3.  Min(4, 6, 5) = 4. `dp=[1, 2, 3, 4]`. `p2++` (2).
4.  Min(6, 6, 5) = 5. `dp=[..., 5]`. `p5++` (1).
5.  Min(6, 6, 10) = 6. `dp=[..., 6]`. `p2++` (3), `p3++` (2). (Both match).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic "Merge K Sorted Lists" concept applied to DP generation.
*Khái niệm "Hợp nhất K danh sách sắp xếp" kinh điển áp dụng cho việc sinh DP.*
---
*Số tiếp theo được xây dựng từ những thành công nhỏ nhất trong quá khứ (nhân thừa số). Đừng vội vã, hãy chọn bước đi nhỏ nhất tiếp theo.*
The next number is built from the smallest past successes (factors). Don't rush, choose the next smallest step.
