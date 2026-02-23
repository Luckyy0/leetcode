# Analysis for UTF-8 Validation
# *Phân tích cho bài toán Xác thực UTF-8*

## 1. Problem Essence & Bitwise Logic
## *1. Bản chất vấn đề & Logic Bitwise*

### The Challenge
### *Thách thức*
Checking if a byte stream conforms to the multi-byte UTF-8 standard. We need to distinguish between the "starting byte" (which tells us the length) and "continuation bytes" (which must start with `10`).

### Strategy: Bit Masking and Counter
### *Chiến lược: Mặt nạ Bit và Bộ đếm*
1.  Use a variable `nBytes` to keep track of how many continuation bytes are expected.
2.  Iterate through each integer (byte) in the input:
    -   If `nBytes == 0` (expecting a new character):
        -   Count the number of leading 1's using bit shifts or masks.
        -   If 1-byte (`0xxxxxxx`): `nBytes = 0`.
        -   If 2-bytes (`110xxxxx`): `nBytes = 1`.
        -   If 3-bytes (`1110xxxx`): `nBytes = 2`.
        -   If 4-bytes (`11110xxx`): `nBytes = 3`.
        -   **Invalid cases:** Starting with `10xxxxxx` (invalid start) or more than 4 bytes (UTF-8 limit).
    -   If `nBytes > 0`:
        -   Check if the byte starts with `10` (`(byte >> 6) == 0b10`).
        -   If yes, decrement `nBytes`.
        -   Otherwise, return `false`.
3.  After the loop, if `nBytes == 0`, return `true`.

---

## 2. Approach: Iterative Bitwise Check
## *2. Hướng tiếp cận: Kiểm tra Bit lặp*

### Logic
### *Logic*
(See above). We use bitwise operations like `>>` and `&` to extract the important bits of each byte.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Linear pass through the data.
    *Hiệu quả O(N): Duyệt tuyến tính qua dữ liệu.*
*   **Constant Space:** Only a few variables needed.
    *Không gian hằng số: Chỉ cần một số biến.*

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

**Input:** `[197, 130, 1]`
- `197` (11000101): `nBytes = 0`. Leading 1s = 2. It's a 2-byte start. `nBytes = 1`.
- `130` (10000010): `nBytes = 1`. Check start: `10`. OK. `nBytes = 0`.
- `1` (00000001): `nBytes = 0`. Leading 1s = 0. It's a 1-byte char. OK.
Result: True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Bit-level validation using a state counter.
*Xác thực mức bit bằng bộ đếm trạng thái.*
---
*Mô hình hóa dữ liệu (UTF-8) cũng giống như việc xây dựng các công trình. Có những viên gạch đóng vai trò nền móng (starting bytes) định hình quy mô cho cả cấu trúc, và những viên gạch phụ trợ (continuation bytes) phải tuân thủ nghiêm ngặt vị trí của mình (10xxxxxx). Chỉ khi mọi thứ khớp đúng thiết kế, công trình mới thực sự vững chãi và có ý nghĩa.*
Data modeling (UTF-8) is like building structures. There are foundation bricks (starting bytes) that shape the scale of the whole structure, and auxiliary bricks (continuation bytes) that must strictly adhere to their positions (10xxxxxx). Only when everything matches the design correctly will the structure truly be solid and meaningful.
