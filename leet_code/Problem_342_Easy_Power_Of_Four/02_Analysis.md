# Analysis for Power of Four
# *Phân tích cho bài toán Lũy thừa của Bốn*

## 1. Problem Essence & Bitwise Ops
## *1. Bản chất vấn đề & Phép toán Bitwise*

### The Pattern
### *Mẫu*
Powers of 4:
1 (0001)
4 (0100)
16 (0001 0000)
64 (0100 0000)
Features:
1.  Must be positive.
2.  Must be a power of 2 (only one bit set).
3.  The single bit must be at an *even* position (0, 2, 4...). Or odd if 1-indexed?
    0-indexed: bit 0 (1), bit 2 (4), bit 4 (16). Yes, even positions.

### Validity Rules
### *Quy tắc Hợp lệ*
1.  `n > 0`.
2.  `n & (n - 1) == 0`. (Power of 2 check).
3.  `n & 0x55555555 != 0`. (Check mask).
    `0x5` is `0101`. `0x55555555` has 1s at positions 0, 2, 4, ...
    If overlaps with mask, then bit is at even pos.
    If `n` is power of 2 but `n & mask == 0`, then bit is at odd pos -> Power of 2 but not 4 (e.g. 2, 8, 32).

### Alternative: Modulo
### *Thay thế: Modulo*
`4^x % 3`.
`4 % 3 = 1`.
`4^x % 3 = (1)^x = 1`.
So `n % 3 == 1`.
Check:
2 % 3 = 2.
8 % 3 = 2.
Power of 2 (`n > 0 && n & (n-1) == 0`) AND `n % 3 == 1`.

---

## 2. Approach: Bitwise Mask / Modulo
## *2. Hướng tiếp cận: Mask Bitwise / Modulo*

### Logic
### *Logic*
(See above). Modulo is cleaner.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1):** No loops.
    *O(1): Không vòng lặp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 16.
Power of 2? Yes (`16 & 15 == 0`).
`16 % 3`. 16 = 3*5 + 1. Remainder 1. True.

**Input:** 8.
Power of 2? Yes.
`8 % 3`. 8 = 3*2 + 2. Remainder 2. False.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Power of 2 check + Modulo 3 check.
*Kiểm tra lũy thừa của 2 + Kiểm tra Modulo 3.*
---
*Chỉ những ai đơn độc (power of 2) nhưng vẫn giữ được sự cân bằng với thế giới xung quanh (modulo 3==1) mới đạt được sức mạnh của lũy thừa 4.*
Only those who are solitary (power of 2) but still maintain balance with the world around them (modulo 3==1) achieve the power of the power of 4.
