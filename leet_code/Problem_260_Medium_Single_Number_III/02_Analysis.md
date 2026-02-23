# Analysis for Single Number III
# *Phân tích cho bài toán Số đơn độc III*

## 1. Problem Essence & Bitwise Magic
## *1. Bản chất vấn đề & Phép thuật Bitwise*

### The Challenge
### *Thách thức*
In Single Number I (one unique, others twice), we used XOR. `a ^ a = 0`, so `result = xor_all`.
Here we have two unique numbers `a` and `b`.
`xor_all = a ^ b`.
Since `a != b`, `xor_all` must be non-zero.
This means `a` and `b` differ in at least one bit.

### The Bitwise Separation
### *Phân tách Bitwise*
1.  Find `xor = a ^ b`.
2.  Find the rightmost set bit of `xor`: `diff = xor & (-xor)`.
    - This bit is 1 in `a` and 0 in `b` (or vice versa).
3.  Divide all numbers in `nums` into two groups based on this bit.
    - Group 1: Numbers with this bit set.
    - Group 2: Numbers with this bit unset.
4.  `a` will be in one group, `b` in the other.
5.  All other duplicates `x, x` will fall into the same group.
6.  XORing Group 1 yields `a`. XORing Group 2 yields `b`.
*Tìm bit khác biệt. Chia mảng thành 2 nhóm dựa trên bit đó. XOR riêng từng nhóm.*

---

## 2. Approach: Bit Manipulation
## *2. Hướng tiếp cận: Thao tác Bit*

### Logic
### *Logic*
1.  `bitmask = 0`. Iterate `nums`, `bitmask ^= num`.
2.  `diff = bitmask & (-bitmask)`. (Isolates the rightmost 1-bit).
3.  `x = 0`. Iterate `nums`:
    - If `(num & diff) != 0`: `x ^= num`.
4.  `y = bitmask ^ x`.
5.  Return `[x, y]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Partitioning:** We effectively reduce the problem to two instances of Single Number I.
    *Phân vùng: Biến bài toán thành hai bài toán Số đơn độc I.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ (Two passes).
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 1, 3, 2, 5]`
Unique: 3, 5.
1.  Bitmask = `1^2^1^3^2^5` = `3^5` = `011 ^ 101` = `110` (6).
2.  Diff = `6 & -6` = `0...0110 & 1...1010` = `0...0010` (2).
    - The bit at index 1 is set. (2^1 = 2).
3.  Group 1 (bit 2 is 0): `1 (001), 1 (001), 5 (101)`. XOR = 5.
    - Wait? 5 has bit 2 (value 4) set? No, bit index 1 (value 2).
    - 5 is `101` (4+1). Bit at val 2 is 0. So 5 is in this group.
    - 1 is `001`. Bit at val 2 is 0.
    - So `1, 1, 5`. XOR = 5. (Found one number).
4.  Group 2 (bit 2 is 1): `2 (010), 3 (011), 2 (010)`.
    - XOR = 3. (Found second number).
5.  Result `[5, 3]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Mastering `x & (-x)` to get the Low Bit is very useful in Binary Indexed Trees and Bitmask problems.
*Thành thạo `x & (-x)` để lấy Low Bit rất hữu ích.*
---
*Đôi khi sự khác biệt chỉ nằm ở một chi tiết nhỏ (1 bit). Nhưng chính chi tiết đó đủ để phân loại và định danh bản thân giữa đám đông.*
Sometimes the difference lies in just one small detail (1 bit). But that detail is enough to categorize and identify oneself in a crowd.
