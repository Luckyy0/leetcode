# Analysis for Missing Number
# *Phân tích cho bài toán Số bị thiếu*

## 1. Problem Essence & Sum/XOR Properties
## *1. Bản chất vấn đề & Tính chất Tổng/XOR*

### The Math Way (Sum)
### *Cách toán học (Tổng)*
We know integers are `0, 1, ..., n`.
Sum of series is $\frac{n(n+1)}{2}$.
Sum of array is `actual_sum`.
`Missing = Expected - Actual`.
Risk: Overflow if `n` is large (though `n=10^4` is fine for int).

### The XOR Way
### *Cách XOR*
`XOR(0...n) ^ XOR(nums)` -> `Missing`.
$a \oplus a = 0$.
Every number appears twice (once in range, once in array) EXCEPT the missing one.
Safe from overflow.

---

## 2. Approach: XOR
## *2. Hướng tiếp cận: XOR*

### Logic
### *Logic*
1.  Initialize `missing = n`.
2.  Iterate `i` from `0` to `n-1`:
    - `missing ^= i ^ nums[i]`.
3.  Return `missing`.
Why `missing = n` initially? Because the loop `i` goes `0` to `n-1`. The range is `0` to `n`. We need to XOR `n` as well. Or loop `0` to `n` and handle array index separately.
Standard: `res = n`. Loop `i` from `0` to `n-1`: `res ^= i ^ nums[i]`.
Equivalent to `(n) ^ (0 ^ nums[0]) ^ (1 ^ nums[1]) ...`.
Effectively `(0^1^...^n) ^ (nums[0]^...^nums[n-1])`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bitwise Efficiency:** Fast, no overflow, constant space.
    *Hiệu quả bitwise: Nhanh, không tràn số, không gian hằng số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[3, 0, 1]` ($n=3$)
`res = 3`.
i=0: `3 ^ 0 ^ 3` = `0`.
i=1: `0 ^ 1 ^ 0` = `1`.
i=2: `1 ^ 2 ^ 1` = `2`.
Result: 2. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

XOR covers all bases. Sum works too.
*XOR bao quát mọi trường hợp. Tổng cũng được.*
---
*Đôi khi những gì còn thiếu (missing) có thể được tìm thấy bằng cách so sánh tổng thể kỳ vọng với thực tế hiện có. Sự thiếu hụt chính là sự khác biệt.*
Sometimes what is missing can be found by comparing the expected whole with the current reality. The deficit is the difference.
