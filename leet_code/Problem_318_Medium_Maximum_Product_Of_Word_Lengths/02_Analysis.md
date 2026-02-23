# Analysis for Maximum Product of Word Lengths
# *Phân tích cho bài toán Tích Lớn nhất của Độ dài Từ*

## 1. Problem Essence & Bitmasks
## *1. Bản chất vấn đề & Bitmasks*

### The Challenge
### *Thách thức*
Check if two words share common letters.
Iterating chars: $O(L_1 \cdot L_2)$.
Total check all pairs: $O(N^2 \cdot L^2)$. Too slow.
We need $O(1)$ check.

### Strategy: Bitmasking
### *Chiến lược: Bitmasking*
26 lowercase letters. An integer has 32 bits.
We can represent the set of characters in a word as a single integer bitmask.
`mask |= 1 << (char - 'a')`.
Check intersections: `(mask1 & mask2) == 0`.
Optimization: If multiple words have same mask, keep the max length.

---

## 2. Approach: Bitmask Array
## *2. Hướng tiếp cận: Mảng Bitmask*

### Logic
### *Logic*
1.  `n = words.length`. `masks` array. `lens` array.
2.  Precompute masks and lengths for all words.
3.  Loop `i` from 0 to `n`:
    - Loop `j` from `i+1` to `n`:
        - If `(masks[i] & masks[j]) == 0`:
            - `maxVal = max(maxVal, lens[i] * lens[j])`.
4.  Return `maxVal`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bitwise Operations:** Extremely fast set intersection.
    *Các phép toán Bitwise: Giao tập hợp cực nhanh.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Precompute $O(N \cdot L)$. Check $O(N^2)$. Total $O(NL + N^2)$.
    *Độ phức tạp thời gian: $O(NL + N^2)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "a", "b"
Mask("a") = `1`. Mask("b") = `2` (`10` bin).
`1 & 2 = 0`. Product `1*1 = 1`.

**Input:** "a", "aa"
Mask("a") = `1`. Mask("aa") = `1`.
`1 & 1 != 0`. Product 0.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard bitmask for small alphabet size.
*Bitmask tiêu chuẩn cho kích thước bảng chữ cái nhỏ.*
---
*Để tìm sự kết hợp hoàn hảo (max product) mà không va chạm (no common letters), hãy nén bản sắc của mỗi cá thể thành những tín hiệu đơn giản nhất (bitmask) để so sánh nhanh chóng.*
To find the perfect combination (max product) without conflict (no common letters), compress the identity of each individual into the simplest signals (bitmask) for quick comparison.
