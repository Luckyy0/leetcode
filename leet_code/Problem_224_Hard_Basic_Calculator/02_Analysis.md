# Analysis for Basic Calculator
# *Phân tích cho bài toán Máy tính cơ bản*

## 1. Problem Essence & Stack Management
## *1. Bản chất vấn đề & Quản lý ngăn xếp*

### The Challenge
### *Thách thức*
We have:
- Non-negative integers.
- Operators `+`, `-`.
- Parentheses `(`, `)`.
- Spaces.
The tricky part is `(` and `)`. Parentheses change the priority of operations.
Basically, `a - (b + c)` becomes `a - b - c`.
*Phần khó là dấu ngoặc. Chúng thay đổi độ ưu tiên. `a - (b + c)` trở thành `a - b - c`.*

### The Sign Flip
### *Đảo dấu*
Instead of fully evaluating the expression inside parentheses recursively, we can think of parentheses as "context switches".
- If we have `- ( ... )`, everything inside the parenthesis is multiplied by `-1` *relative to the outside context*.
*Thay vì đánh giá đệ quy, hãy coi ngoặc là "chuyển đổi ngữ cảnh". Nếu có `- (...)`, mọi thứ bên trong được nhân với `-1` so với bên ngoài.*

---

## 2. Approach: Iterative Stack
## *2. Hướng tiếp cận: Ngăn xếp lặp*

### Logic
### *Logic*
We maintain:
- `currentResult`: The sum calculated so far in the current parenthesis level.
- `currentSign`: The sign (`+1` or `-1`) to apply to the *next* number.
- `stack`: To store the `result` and `sign` of the *outer* level when we enter a parenthesis `(`.

Algorithm:
1.  Initialize `result = 0`, `sign = 1`.
2.  Iterate char by char.
    - **Digit:** Parse the full number. Add `sign * number` to `result`.
    - **'+':** Set `sign = 1`.
    - **'-':** Set `sign = -1`.
    - **'(':** Push `result` and `sign` to stack. Reset `result = 0`, `sign = 1`. (Start new context).
    - **')':** End of context.
        - Pop `prevSign` (sign before the bracket).
        - Pop `prevResult` (result before the bracket).
        - `result = prevResult + prevSign * result`.
    - **Space:** Ignore.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursion unwinding:** The stack mimics the recursion call stack but is iterative and potentially faster / less memory overhead for deep nesting.
    *Gỡ rối đệ quy: Ngăn xếp mô phỏng ngăn xếp cuộc gọi đệ quy nhưng lặp đi lặp lại và có khả năng nhanh hơn / ít tốn bộ nhớ hơn.*
*   **Simple arithmetic:** We only do `+` and `-`. No multiplication, so no precedence rules other than parentheses.
    *Tính toán đơn giản: Chỉ có cộng trừ, không nhân chia.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the stack (in case of deeply nested parentheses `((((...))))`).
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `1 - (2 + 3)`

1.  `res=0, sign=1`. '1' -> `res=1`.
2.  '-' -> `sign=-1`.
3.  '(' -> Push `[1, -1]`. Reset `res=0, sign=1`.
4.  '2' -> `res=2`.
5.  '+' -> `sign=1`.
6.  '3' -> `res = 2 + 1*3 = 5`.
7.  ')' ->
    - Pop `prevSign = -1`.
    - Pop `prevRes = 1`.
    - `res = 1 + (-1) * 5 = -4`.

**Result:** -4. Correct (`1 - 5`).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Basic Calculator is a classic stack problem. The key trick is handling parentheses by pushing the "context" (stored result and sign) onto the stack and resetting. This avoids complex recursion or string manipulation.
*Máy tính cơ bản là bài toán ngăn xếp kinh điển. Mẹo chính là xử lý dấu ngoặc bằng cách đẩy "ngữ cảnh" (kết quả đã lưu và dấu) vào ngăn xếp và thiết lập lại.*
---
*Mỗi dấu ngoặc mở là một lời hứa sẽ quay lại, mỗi dấu ngoặc đóng là sự hoàn thành của một lời hứa đó.*
Every opening bracket is a promise to return, every closing bracket is the fulfillment of that promise.
