# Analysis for Number of 1 Bits
# *Phân tích cho bài toán Số lượng Bit 1*

## 1. Problem Essence & Bit Counting
## *1. Bản chất vấn đề & Đếm Bit*

### The Task
### *Nhiệm vụ*
We simply need to count how many `1`s are in the 32-bit binary representation of an integer.
*Chúng ta chỉ cần đếm xem có bao nhiêu số `1` trong biểu diễn nhị phân 32-bit của một số nguyên.*

### Approaches
### *Các phương pháp tiếp cận*
1.  **Loop Check:** Check check bit at positions 0 to 31.
2.  **Bit Manipulation Trick:** Use `n & (n - 1)`.
3.  **Built-in:** `Integer.bitCount(n)`.
*1. Kiểm tra vòng lặp: Kiểm tra từng bit từ 0 đến 31. 2. Thủ thuật Bit: Sử dụng `n & (n - 1)`. 3. Có sẵn: `Integer.bitCount(n)`.*

---

## 2. Approach 1: The Brian Kernighan's Algorithm (Reference)
## *2. Hướng tiếp cận 1: Thuật toán Brian Kernighan (Tham khảo)*

### Use `n & (n - 1)`
### *Sử dụng `n & (n - 1)`*
This is valid for optimizing purposes.
- `n - 1`: Flips the least significant bit that is `1` to `0` and all subsequent `0`s to `1`s.
- `n & (n - 1)`: Effectively **removes** the lowest set bit from `n`.
*`n - 1` lật bit 1 có ý nghĩa thấp nhất thành 0 và tất cả các bit 0 theo sau thành 1. `n & (n - 1)` thực sự **loại bỏ** bit 1 thấp nhất khỏi `n`.*

Example: `n = 12 (1100)`
1.  `n - 1 = 11 (1011)`
2.  `n & (n-1) = 1100 & 1011 = 1000 (8)` -> Removed the rightmost `1`.
3.  `count++`.

Repeating this until `n` becomes 0 gives the exact number of set bits. This runs in time proportional to the number of set bits, which is faster than iterating all 32 bits for sparse numbers.
*Lặp lại quá trình này cho đến khi `n` bằng 0 sẽ cho ra số lượng chính xác các bit 1. Nó chạy trong thời gian tỷ lệ thuận với số lượng bit 1, nhanh hơn việc duyệt tất cả 32 bit đối với các số thưa.*

---

## 3. Approach 2: Simple Loop (for "unsigned" handling)
## *3. Hướng tiếp cận 2: Vòng lặp đơn giản (để xử lý "không dấu")*

Since Java doesn't strictly have unsigned integers, if `n` is negative (sign bit is 1), `n > 0` condition might fail if logical shift isn't used.
*Vì Java không có số nguyên không dấu nghiêm ngặt, nếu `n` là âm (bit dấu là 1), điều kiện `n > 0` có thể sai nếu không dùng phép dịch logic.*

We can loop 32 times and check `(n & 1)`.
Or use `n >>>= 1` while logic shifting until `n == 0`.
*Chúng ta có thể lặp 32 lần và kiểm tra `(n & 1)`. Hoặc sử dụng `n >>>= 1` trong khi dịch logic cho đến khi `n == 0`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. It's at most 32 operations.
    *Độ phức tạp thời gian: $O(1)$. Tối đa 32 phép toán.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = 11 (1011)`

**Method: n & (n-1)**
1. `count = 0`
2. `n = 1011`. `n-1 = 1010`. `n & (n-1) = 1010`. `count = 1`.
3. `n = 1010`. `n-1 = 1001`. `n & (n-1) = 1000`. `count = 2`.
4. `n = 1000`. `n-1 = 0111`. `n & (n-1) = 0000`. `count = 3`.
5. `n = 0`. Stop.

**Result:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

In a standard interview, `n & (n-1)` is the expected "smart" solution. However, since the problem mentions "unsigned", be careful. In Java, if input is treated as signed int but logic requires unsigned behavior, `n != 0` works for checking non-zero even if negative (since negative is just a bit pattern).
*Trong phỏng vấn, `n & (n-1)` là giải pháp thông minh được mong đợi. Tuy nhiên, hãy cẩn thận với "số không dấu". Trong Java, điều kiện `n != 0` hoạt động tốt để kiểm tra khác không ngay cả khi số đó là âm.*
---
*Đếm những gì đang tỏa sáng luôn dễ dàng hơn là mò mẫm trong bóng tối của những khoảng trống.*
Counting what is shining is always easier than groping in the darkness of voids.
