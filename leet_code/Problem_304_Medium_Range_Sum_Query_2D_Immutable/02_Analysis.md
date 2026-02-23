# Analysis for Range Sum Query 2D - Immutable
# *Phân tích cho bài toán Truy vấn Tổng trong Phạm vi 2D - Bất biến*

## 1. Problem Essence & 2D Prefix Sum
## *1. Bản chất vấn đề & Tổng tiền tố 2D*

### The Challenge
### *Thách thức*
Query sum of sub-rectangle many times ($10^4$). Matrix static.
Naive: $O(M \cdot N)$ per query. Too slow.

### Strategy: 2D Prefix Sum (Integral Image)
### *Chiến lược: Tổng tiền tố 2D (Integral Image)*
Let `dp[i][j]` be the sum of rectangle from `(0,0)` to `(i,j)`.
Recurrence: `dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]`.
(Subtract intersection because added twice).

To find sum of region `(r1, c1)` to `(r2, c2)`:
`Sum = dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1]`.
Visual: Big Area - Top Strip - Left Strip + Top-Left Intersection (added back).

---

## 2. Approach: 2D DP
## *2. Hướng tiếp cận: DP 2D*

### Logic
### *Logic*
1.  Init `dp[m+1][n+1]` with 0.
2.  Fill `dp`:
    `dp[i+1][j+1] = matrix[i][j] + dp[i][j+1] + dp[i+1][j] - dp[i][j]`.
3.  Query:
    `dp[r2+1][c2+1] - dp[r1][c2+1] - dp[r2+1][c1] + dp[r1][c1]`.
    (Using 1-based indexing simplifies boundary checks for row1=0/col1=0).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Geometric Subtraction:** Uses the Principle of Inclusion-Exclusion.
    *Phép trừ hình học: Sử dụng Nguyên lý Bao hàm - Loại trừ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Init $O(M \cdot N)$, Query $O(1)$.
    *Độ phức tạp thời gian: Khởi tạo O(M \cdot N), Truy vấn O(1).*
*   **Space Complexity:** $O(M \cdot N)$.
    *Độ phức tạp không gian: O(M \cdot N).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[1, 2], [3, 4]]`
DP:
`0 0 0`
`0 1 3` (1, 1+2)
`0 4 10` (1+3, 1+2+3+4)
Query `(0,0) - (1,1)`: `dp[2][2] - dp[0][2] - dp[2][0] + dp[0][0]` = `10 - 0 - 0 + 0 = 10`. Correct.
Query `(1,1) - (1,1)`: `dp[2][2] - dp[1][2] - dp[2][1] + dp[1][1]`
= `10 - 3 - 4 + 1` = `4`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard 2D extension of Prefix Sum.
*Mở rộng tiêu chuẩn 2D của Tổng tiền tố.*
---
*Toàn bộ (sumRegion) được tạo thành từ các mảnh ghép. Để tách một phần ra, ta phải cắt bỏ những phần thừa (subtraction) và bù đắp lại những chỗ cắt quá tay (addition).*
The whole (sumRegion) is made of pieces. To extract a part, we must cut away the excess (subtraction) and compensate for overlapping cuts (addition).
