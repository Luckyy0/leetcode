# Analysis for Basic Calculator II
# *Phân tích cho bài toán Máy tính cơ bản II*

## 1. Problem Essence & Precedence
## *1. Bản chất vấn đề & Thứ tự ưu tiên*

### The Challenge
### *Thách thức*
Unlike Calculator I (only + and -), this one has `*` and `/`.
Multiplication and Division have **higher priority** than Addition and Subtraction.
`3 + 2 * 2` should be `3 + 4 = 7`, not `5 * 2 = 10`.
*Nhân chia làm trước, cộng trừ làm sau.*

### The Stack Approach
### *Hướng tiếp cận ngăn xếp*
We can process the string linearly.
- If we see `+` or `-`, we can't calculate immediately because a `*` might come next. We push the number (with its sign) to a stack.
- If we see `*` or `/`, we MUST calculate immediately with the previous number (top of stack).
    - `prev = stack.pop()`
    - `newVal = prev * currentNum`
    - `stack.push(newVal)`
- Finally, sum up all values in the stack.

*Gặp cộng trừ: Đẩy vào stack (đổi dấu nếu trừ). Gặp nhân chia: Lấy đỉnh stack ra tính ngay rồi đẩy lại. Cuối cùng cộng hết stack.*

---

## 2. Approach: Stack with Sign Tracking
## *2. Hướng tiếp cận: Ngăn xếp với Theo dõi dấu*

### Logic
### *Logic*
Main loop variables: `num` (current number), `lastSign` (operator before the current number).
Initial `lastSign = '+'`.

Iterate through string `s` + a dummy char at end (optional) or handle end of loop.
1.  If Digit: Build `num`.
2.  If Operator (`+` `-` `*` `/`) or End of String:
    - Depending on `lastSign`:
        - `+`: `stack.push(num)`
        - `-`: `stack.push(-num)`
        - `*`: `stack.push(stack.pop() * num)`
        - `/`: `stack.push(stack.pop() / num)`
    - Update `lastSign = currentChar`.
    - Reset `num = 0`.

3.  After loop, `sum(stack)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Deferred Addition:** The stack essentially delays the lower-priority operations (addition/subtraction) until all higher-priority operations are resolved.
    *Cộng chậm: Ngăn xếp trì hoãn các phép tính ưu tiên thấp cho đến khi các phép tính ưu tiên cao được giải quyết.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for stack. Can be optimized to $O(1)$ by just keeping `lastNumber` instead of full stack (since we only sum at the end).
    *Độ phức tạp không gian: $O(N)$. Có thể tối ưu xuống $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `3 + 5 / 2`

Initialization: `num=0, lastSign='+'`

1.  '3'. `num=3`.
2.  '+'. Process `3` with `lastSign (+)`. Stack: `[3]`. `lastSign='+'`. `num=0`.
3.  '5'. `num=5`.
4.  '/'. Process `5` with `lastSign (+)`. Stack: `[3, 5]`. `lastSign='/'`. `num=0`.
5.  '2'. `num=2`.
6.  End. Process `2` with `lastSign (/)`.
    - Pop 5.
    - `5 / 2 = 2`.
    - Push 2. Stack: `[3, 2]`.
7.  Sum stack: `3 + 2 = 5`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This pattern (Accumulate number -> Apply previous operator -> Push to stack/Update Last Num) handles precedence elegantly without expression trees.
*Mẫu này (Tích lũy số -> Áp dụng toán tử trước -> Đẩy vào stack) xử lý thứ tự ưu tiên một cách thanh lịch mà không cần cây biểu thức.*
---
*Trong toán học cũng như cuộc sống, một số việc cần được ưu tiên giải quyết ngay lập tức (nhân/chia), trong khi những việc khác có thể chờ đợi (cộng/trừ).*
In math as in life, some things need priority attention immediately (multiplication/division), while others can wait (addition/subtraction).
