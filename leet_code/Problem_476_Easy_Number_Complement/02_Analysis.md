# Analysis for Number Complement
# *Phân tích cho bài toán Phần bù của Số*

## 1. Problem Essence & Bit Masking
## *1. Bản chất vấn đề & Mặt nạ Bit*

### The Challenge
### *Thách thức*
Flipping bits of a positive integer, but ignoring the leading zeros.
- `~5` (bitwise NOT) flips *all* 32 bits. E.g., `0...000101` $\to$ `1...111010`.
- We only want to flip the bits relevant to the value (`101` $\to$ `010`).
- So we need `~num & MASK`, where `MASK` has `1`s exactly where `num` has significant bits.

### Strategy: XOR with All-Ones Mask
### *Chiến lược: XOR với Mặt nạ Toàn số 1*

1.  **Construct Mask:** Find a number `mask` consisting of all `1`s that has the same length as `num`.
    - Example: For `5` (`101`), mask is `111` (`7`).
    - `5 ^ 7` = `101 ^ 111` = `010` = `2`.
2.  **Algorithm to find mask:**
    - Method A: While-loop shifts. Start with `mask = 1`, shift left until `mask > num`, then `mask - 1`. Or build up `111...` directly.
    - Method B: Java `Integer.highestOneBit(num)`. Let `h` be highest bit (e.g. `100`). `(h << 1) - 1` gives `111`. Careful with overflow if `h` is the 31st bit.

---

## 2. Approach: Bit Manipulation
## *2. Hướng tiếp cận: Thao tác Bit*

### Logic
### *Logic*
(See above). `highestOneBit` approach is cleanest. If `num = 5` (`101`), `h` is `4` (`100`). `h << 1` is `8` (`1000`). `8 - 1` is `7` (`111`). `num ^ 7` is `2`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Efficiency:** No loops (or limited loop to 32).
    *Hiệu quả O(1): Không có vòng lặp (hoặc giới hạn 32 lần).*
*   **Direct Logic:** XOR toggles bits.
    *Logic trực tiếp: XOR đảo ngược các bit.*

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

**Input:** `5 (101)`
1. Highest One Bit `h`: `100` (4).
2. Mask: `(4 << 1) - 1` = `8 - 1` = `7` (`111`).
3. `5 ^ 7` = `101 ^ 111` = `010` = `2`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

XOR with a mask of all 1s corresponding to the bit length.
*XOR với mặt nạ toàn số 1 tương ứng với độ dài bit.*
---
*Trong thế giới nhị phân, phần bù (complement) chính là nửa kia hoàn hảo. Để tìm thấy nó, ta không cần thay đổi cả vũ trụ (flip leading zeros), mà chỉ cần soi chiếu vào chính giới hạn của sự tồn tại (significant bits mask). Khi ta biết mình rộng lớn đến đâu, ta sẽ biết mình còn thiếu những gì để trở nên trọn vẹn.*
In binary world, complement (complement) is the perfect other half. To find it, we do not need to change the whole universe (flip leading zeros), but only need to reflect into the limit of existence (significant bits mask). When we know how extensive we are, we will know what we are missing to become complete.
