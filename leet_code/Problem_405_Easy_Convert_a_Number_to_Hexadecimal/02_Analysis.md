# Analysis for Convert a Number to Hexadecimal
# *Phân tích cho bài toán Chuyển đổi Số sang Hệ Thập lục phân*

## 1. Problem Essence & Bitwise Extraction
## *1. Bản chất vấn đề & Trích xuất Bitwise*

### The Challenge
### *Thách thức*
Converting a 32-bit signed integer to base-16. Negative numbers are represented in "two's complement", which in hexadecimal just looks like its unsigned bit pattern (e.g., -1 is all 1s, which is `ffffffff`).

### Strategy: 4-Bit Chunking
### *Chiến lược: Chia nhỏ 4-Bit*
Every hexadecimal digit represents exactly 4 bits ($2^4 = 16$).
1.  **Map:** Create a mapping of 0-15 to '0'-'9' and 'a'-'f'.
2.  **Process:**
    - If `num == 0`, return "0".
    - Use a loop (at most 8 times for a 32-bit integer).
    - Get the last 4 bits using `num & 15` (bitwise AND with `0xF`).
    - Append the corresponding character from the Map to the **front** of a StringBuilder.
    - Shift `num` to the right by 4 bits using the **unsigned right shift operator** `>>>`.
    - `>>>` is crucial as it fills the leading bits with 0s regardless of the sign.

---

## 2. Approach: Iterative Bit Masks
## *2. Hướng tiếp cận: Mặt nạ Bit lặp*

### Logic
### *Logic*
(See above). The unsigned shift will eventually make the number 0, but since we handle 32-bit, at most 8 iterations cover all bits.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Complexity:** Always at most 8 iterations for any 32-bit integer.
    *Hiệu quả O(1): Luôn tối đa 8 lần lặp cho bất kỳ số nguyên 32-bit nào.*
*   **Sign Agnostic:** The bitwise logic automatically handles two's complement without needing separate logic for negative numbers.
    *Không phụ thuộc vào dấu: Logic bitwise tự động xử lý bù hai mà không cần logic riêng cho số âm.*

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

**Input:** `num = 26` (Binary `...0001 1010`)
1. `26 & 15` = 10. Char = 'a'. StringBuilder = "a".
2. `26 >>> 4` = 1 (Binary `...0001`). 
3. `1 & 15` = 1. Char = '1'. StringBuilder = "1a".
4. `1 >>> 4` = 0. Loop stops.
Result: "1a".

**Input:** `num = -1` (Binary `1111 1111 ... 1111`)
1. Each `& 15` gives 15. Char = 'f'.
2. Iterates 8 times.
Result: "ffffffff".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Unsigned right shift (`>>>`) and bit masking.
*Dịch phải không dấu (>>>) và sử dụng mặt nạ bit.*
---
*Hệ thập lục phân (hex) là cách con người nhìn vào bản chất thực sự của dữ liệu mức thấp (bits). Bằng cách bóc tách từng lớp 4-bit một (chunking), ta có thể giải mã được diện mạo của những con số, kể cả khi chúng mang trong mình gánh nặng của sự tiêu cực (negative/two's complement).*
Hexadecimal (hex) is how humans look at the true nature of low-level data (bits). By peeling off each 4-bit layer (chunking), we can decode the appearance of numbers, even when they carry the burden of negativity (negative/two's complement).
