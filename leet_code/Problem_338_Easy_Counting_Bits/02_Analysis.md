# Analysis for Counting Bits
# *Phân tích cho bài toán Đếm Bit*

## 1. Problem Essence & Bitwise Relations
## *1. Bản chất vấn đề & Quan hệ Bitwise*

### The Pattern
### *Mẫu*
Need to count 1s for all numbers up to `n`.
`i` vs `i/2` (`i >> 1`).
if `i` is even (e.g., 2, 4, 6), `i` has same bits as `i/2`, just shifted. LSB is 0.
if `i` is odd (e.g., 3, 5, 7), `i` has same bits as `i/2` plus one extra bit (LSB is 1).
Formula: `dp[i] = dp[i >> 1] + (i & 1)`.

### Alternative
### *Thay thế*
`i & (i-1)` removes the lowest set bit.
`dp[i] = dp[i & (i-1)] + 1`.

### Strategy: DP
### *Chiến lược: DP*
Iterate 1 to `n`. Fill array.

---

## 2. Approach: DP (LSB)
## *2. Hướng tiếp cận: DP (LSB)*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single pass.
    *Thời gian O(N): Một lần duyệt.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (output array).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 5
dp[0] = 0.
dp[1] = dp[0] + 1 = 1.
dp[2] = dp[1] + 0 = 1.
dp[3] = dp[1] + 1 = 2.
dp[4] = dp[2] + 0 = 1.
dp[5] = dp[2] + 1 = 2.
Result: [0, 1, 1, 2, 1, 2].

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DP with `i >> 1`.
*DP với `i >> 1`.*
---
*Những con số lớn (i) hóa ra chỉ là phiên bản mở rộng (shift) của quá khứ (i/2), đôi khi thêm một chút bản sắc riêng (LSB) để trở nên khác biệt.*
Big numbers (i) turn out to be just expanded versions (shift) of the past (i/2), sometimes adding a little unique identity (LSB) to become different.
