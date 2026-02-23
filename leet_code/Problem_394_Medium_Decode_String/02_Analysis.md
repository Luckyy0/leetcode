# Analysis for Decode String
# *Phân tích cho bài toán Giải mã Chuỗi*

## 1. Problem Essence & Stack-based Expansion
## *1. Bản chất vấn đề & Mở rộng dựa trên Ngăn xếp*

### The Challenge
### *Thách thức*
Expanding nested blocks of strings based on multipliers. This requires keeping track of "what we were doing before" when we encounter a new opening bracket `[`.

### Strategy: Two Stacks
### *Chiến lược: Hai Ngăn xếp*
1.  **Count Stack:** Stores the multipliers ($k$).
2.  **String Stack:** Stores the accumulated string builders *before* the current bracket level.
3.  **Process:**
    -   `Digit`: Accumulate the number (handle multi-digit cases).
    -   `[`: 
        -   Push current multiplier to `Count Stack`.
        -   Push current accumulated string to `String Stack`.
        -   Reset current multiplier and string.
    -   `]`:
        -   Pop multiplier $k$.
        -   Pop prefix string from `String Stack`.
        -   Append current string $k$ times to the prefix string.
        -   Result becomes the new current string.
    -   `Letter`: Simply append to current string.

---

## 2. Approach: Iterative Stack
## *2. Hướng tiếp cận: Ngăn xếp Lặp*

### Logic
### *Logic*
(See above). The stacks allow us to handle arbitrary nesting of `[]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** We process each character of the encoded string once (though the output string can be larger).
    *Hiệu quả O(N): Chúng ta xử lý mỗi ký tự của chuỗi mã hóa một lần.*
*   **Intuitive Nesting:** Stacks naturally handle the "LIFO" nature of nested brackets.
    *Lồng nhau trực quan: Ngăn xếp xử lý tự nhiên tính chất "vào sau ra trước" của các dấu ngoặc lồng nhau.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\text{length of decoded string})$. We must construct the final string.
    *Độ phức tạp thời gian: $O(\text{độ dài chuỗi sau giải mã})$.*
*   **Space Complexity:** $O(\text{nesting depth} + \text{length of decoded string})$.
    *Độ phức tạp không gian: $O(\text{độ sâu lồng} + \text{độ dài chuỗi sau giải mã})$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `3[a2[c]]`
1. `3`: `currK = 3`.
2. `[`: `StackK: [3]`, `StackStr: [""]`. `currStr = ""`.
3. `a`: `currStr = "a"`.
4. `2`: `currK = 2`.
5. `[`: `StackK: [3, 2]`, `StackStr: ["", "a"]`. `currStr = ""`.
6. `c`: `currStr = "c"`.
7. `]`: Pop $k=2, prefix="a"$. New `currStr = "a" + "cc" = "acc"`.
8. `]`: Pop $k=3, prefix=""$. New `currStr = "" + "acc" + "acc" + "acc" = "accaccacc"`.
Result: "accaccacc".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two separate stacks for counts and strings.
*Hai ngăn xếp riêng biệt cho số lượng và chuỗi.*
---
*Giải mã thông tin (decoding) cũng giống như việc tháo gỡ một cuộn len bị rối. Bằng cách ghi nhớ những gì đã đi qua (stacks) và xử lý từng nút thắt (brackets) theo đúng lớp lang, ta sẽ khôi phục lại được toàn bộ bức tranh nguyên bản một cách trọn vẹn nhất.*
Decoding information is like untangling a tangled ball of yarn. By remembering what has been passed (stacks) and processing each knot (brackets) in the correct order, we will restore the entire original picture in the most complete way.
