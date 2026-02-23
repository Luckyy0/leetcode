# Analysis for Add Strings
# *Phân tích cho bài toán Cộng Chuỗi*

## 1. Problem Essence & Column Addition
## *1. Bản chất vấn đề & Phép cộng theo Cột*

### The Challenge
### *Thách thức*
Adding two numbers that are too large to fit into standard integer types. We must simulate the process of manual column addition, starting from the least significant digit (rightmost).

### Strategy: Two Pointers + Carry
### *Chiến lược: Hai con trỏ + Số nhớ*
1.  Initialize `i` at the end of `num1` and `j` at the end of `num2`.
2.  Initialize `carry = 0`.
3.  Loop while `i >= 0` or `j >= 0` or `carry > 0`:
    - Get digit `x` from `num1` (0 if `i < 0`).
    - Get digit `y` from `num2` (0 if `j < 0`).
    - `sum = x + y + carry`.
    - `digitToAppend = sum % 10`.
    - `carry = sum / 10`.
    - Append `digitToAppend` to a `StringBuilder`.
    - Decrement `i` and `j`.
4.  **Reverse** the `StringBuilder` and return.

---

## 2. Approach: Iterative Simulation
## *2. Hướng tiếp cận: Mô phỏng Lặp*

### Logic
### *Logic*
(See above). The use of `StringBuilder` and `reverse()` is more efficient than prepending to a string repeatedly.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Linear pass through the characters of the strings.
    *Hiệu quả O(N): Duyệt tuyến tính qua các ký tự của chuỗi.*
*   **Arbitrary Precision:** Can handle numbers of any length as long as they fit in memory.
    *Độ chính xác tùy ý: Có thể xử lý các số có độ dài bất kỳ miễn là vừa bộ nhớ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\max(L_1, L_2))$, where $L_1, L_2$ are the lengths of the strings.
    *Độ phức tạp thời gian: $O(\max(L_1, L_2))$.*
*   **Space Complexity:** $O(\max(L_1, L_2))$ for the output string.
    *Độ phức tạp không gian: $O(\max(L_1, L_2))$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `"456" + "77"`
1. `6 + 7 = 13`. Append `3`, Carry `1`.
2. `5 + 7 + 1 = 13`. Append `3`, Carry `1`.
3. `4 + 0 + 1 = 5`. Append `5`, Carry `0`.
4. StringBuilder: `335`. Reverse: `533`.
Result: "533".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

StringBuilder simulation with carry.
*Mô phỏng bằng StringBuilder với số nhớ.*
---
*Số lớn đến mấy (large numbers) cũng bắt đầu từ những đơn vị nhỏ nhất (digits). Bằng cách điềm tĩnh xử lý từng cột (column-by-column) và ghi nhớ phần dư (carry), ta có thể giải quyết được những thách thức vượt quá giới hạn thông thường (primitive types) một cách chính xác tuyệt đối.*
No matter how large the numbers (large numbers), they all start from the smallest units (digits). By calmly processing each column (column-by-column) and remembering the remainder (carry), we can solve challenges that exceed standard limits (primitive types) with absolute precision.
