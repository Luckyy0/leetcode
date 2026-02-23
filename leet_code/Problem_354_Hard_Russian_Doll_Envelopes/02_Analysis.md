# Analysis for Russian Doll Envelopes
# *Phân tích cho bài toán Phong bao Búp bê Nga*

## 1. Problem Essence & Reduction to LIS
## *1. Bản chất vấn đề & Chuyển đổi sang LIS*

### The Challenge
### *Thách thức*
We need to find a sequence $[[w_1, h_1], [w_2, h_2], \dots, [w_k, h_k]]$ such that $w_1 < w_2 < \dots < w_k$ and $h_1 < h_2 < \dots < h_k$.
This looks like a 2D Longest Increasing Subsequence (LIS) problem.

### Strategy: Sorting + 1D LIS
### *Chiến lược: Sắp xếp + LIS 1 chiều*
1.  **Sort by Width:** Sort envelopes by width in ascending order.
    - If widths are different ($w_i < w_j$), we only need to worry about the height $h_i < h_j$.
2.  **Handle Same Width:** If widths are the same ($w_i = w_j$), we **must not** pick both.
    - Trick: Sort heights in **descending** order for the same width.
    - Why? In an LIS calculation on heights, a descending sequence $(5, 4, 3)$ will ensure only **one** (or none) height is picked for that width.
3.  **Perform LIS on Heights:** Use the $O(N \log N)$ Patience Sorting algorithm to find the LIS of the height array.

---

## 2. Approach: Sorting + Binary Search LIS
## *2. Hướng tiếp cận: Sắp xếp + LIS Tìm kiếm Nhị phân*

### Logic
### *Logic*
(See above). The Patience Sorting algorithm maintains an array `tails` where `tails[i]` is the smallest tail of all increasing subsequences of length `i+1`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N log N) Efficiency:** Sorting takes $O(N \log N)$ and LIS takes $O(N \log N)$. This handles the $10^5$ constraint comfortably.
    *Hiệu quả O(N log N): Sắp xếp và LIS đều mất O(N log N). Điều này xử lý tốt ràng buộc 10^5.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ to store the `tails` array or the sorted envelopes.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[5,4], [6,4], [6,7], [2,3]]`
1. Sort: `[2,3], [5,4], [6,7], [6,4]` (Note: 6,7 precedes 6,4 because 7 > 4).
2. Heights: `[3, 4, 7, 4]`
3. LIS on Heights:
   - `3`: tails = `[3]`
   - `4`: tails = `[3, 4]`
   - `7`: tails = `[3, 4, 7]`
   - `4`: replaces 4 with 4 (no change).
Result: Length 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sort (W asc, H desc) then LIS on H.
*Sắp xếp (W tăng, H giảm) sau đó tìm LIS trên H.*
---
*Đôi khi chúng ta cần biết cách gạt bỏ những giá trị có vẻ giống nhau (same width) bằng cách sắp xếp chúng theo chiều ngược lại (descending height), để cuối cùng chỉ giữ lại những gì thực sự mang tính tiến bộ (LIS).*
Sometimes we need to know how to discard seemingly similar values (same width) by sorting them in reverse (descending height), so that in the end, we only keep what is truly progressive (LIS).
