# Analysis for Range Sum Query - Immutable
# *Phân tích cho bài toán Truy vấn Tổng trong Phạm vi - Bất biến*

## 1. Problem Essence & Prefix Sum
## *1. Bản chất vấn đề & Tổng tiền tố*

### The Challenge
### *Thách thức*
Frequent queries for sum of range `[L, R]`. Array is immutable.
Naive loop: $O(N)$ per query. Total $O(N \cdot Q)$. Too slow.

### Strategy: Prefix Sum Array
### *Chiến lược: Mảng Tổng tiền tố*
Precompute `prefix[i] = sum(nums[0...i-1])`.
Then `sum(i...j) = prefix[j+1] - prefix[i]`.
Example: `nums = [1, 2, 3]`.
`prefix = [0, 1, 3, 6]`.
`sum(1...2)` (vals 2,3 -> 5) = `prefix[3] - prefix[1] = 6 - 1 = 5`. Correct.

---

## 2. Approach: Prefix Sum
## *2. Hướng tiếp cận: Tổng tiền tố*

### Logic
### *Logic*
1.  Constructor: Create `int[] sum` of size `n + 1`.
2.  `sum[0] = 0`.
3.  Loop `i` from 0 to n: `sum[i+1] = sum[i] + nums[i]`.
4.  `sumRange(i, j)`: Return `sum[j+1] - sum[i]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Query:** Constant time retrieval.
    *Truy vấn O(1): Truy xuất thời gian hằng số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Init $O(N)$, Query $O(1)$.
    *Độ phức tạp thời gian: Khởi tạo O(N), Truy vấn O(1).*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: O(N).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[-2, 0, 3, -5]`
Prefix: `[0, -2, -2, 1, -4]`
Query `(0, 2)`: `P[3] - P[0] = 1 - 0 = 1`. (`-2+0+3=1`).
Query `(2, 5)`... range logic.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard pattern. The formula `P[R+1] - P[L]` is key.
*Mẫu tiêu chuẩn. Công thức `P[R+1] - P[L]` là chìa khóa.*
---
*Đôi khi để biết giá trị của hiện tại (sum range), ta cần nhìn lại sự tích lũy của quá khứ (prefix sum) và loại bỏ những gì không còn liên quan.*
Sometimes to know the value of the present (sum range), we need to look back at the accumulation of the past (prefix sum) and subtract what is no longer relevant.
