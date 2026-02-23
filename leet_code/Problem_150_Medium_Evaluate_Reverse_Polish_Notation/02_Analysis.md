# Analysis for Evaluate Reverse Polish Notation
# *Phân tích cho bài toán Đánh giá biểu thức ký pháp Ba Lan ngược*

## 1. Problem Essence & Stack Logic
## *1. Bản chất vấn đề & Logic ngăn xếp*

### What is Reverse Polish Notation (RPN)?
### *Ký pháp Ba Lan ngược (RPN) là gì?*
RPN is a mathematical notation in which operators follow their operands. It eliminates the need for parentheses and operator precedence rules (like BODMAS/PEMDAS).
*RPN là một ký pháp toán học trong đó các toán tử đi sau các toán hạng. Nó loại bỏ sự cần thiết của dấu ngoặc đơn và các quy tắc ưu tiên toán tử.*

### Stack as the Engine
### *Ngăn xếp là động cơ*
The nature of RPN mirrors the **Last-In First-Out (LIFO)** behavior of a stack perfectly. 
- When we see a number (operand), we store it because we don't know yet which operator will use it.
- When we see an operator, it must apply to the most recent numbers we have seen.
*Bản chất của RPN phản ánh hoàn hảo hành vi **Vào sau Ra trước (LIFO)** của một ngăn xếp.*
*- Khi thấy một số (toán hạng), chúng ta lưu trữ nó vì chưa biết toán tử nào sẽ sử dụng nó.*
*- Khi thấy một toán tử, nó phải được áp dụng cho những con số gần đây nhất mà chúng ta đã thấy.*

---

## 2. Approach: Single Pass with Stack
## *2. Hướng tiếp cận: Một lần duyệt với Ngăn xếp*

### Algorithm Steps
### *Các bước thuật toán*
1.  Initialize an empty `Stack<Integer>`.
2.  Iterate through each string `token` in the input array.
3.  If the `token` is an operator (`+`, `-`, `*`, `/`):
    - Pop the top two elements from the stack. Let the first popped be `b` and the second be `a`.
    - **CRITICAL:** The order matters for `-` and `/`. The operation is `a (operator) b`.
    - Apply the operation and push the result back onto the stack.
4.  If the `token` is a number:
    - Parse it to an integer and push it onto the stack.
5.  After the loop, the stack will contain exactly one element: the final result.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Simplicity:** The logic is naturally linear. We process each token once and perform constant-time stack operations.
    *Sự đơn giản tuyến tính: Logic vốn mang tính tuyến tính. Chúng ta xử lý mỗi token một lần và thực hiện các thao tác ngăn xếp trong thời gian hằng số.*
*   **No Precedence Handling:** Unlike infix expressions (e.g., `2 + 3 * 4`), RPN has no ambiguity. There is no need to compare operator weights.
    *Không xử lý thứ tự ưu tiên: Không giống như các biểu thức trung tố, RPN không có sự mơ hồ. Không cần so sánh trọng số toán tử.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of tokens. We iterate through the array once.
    *Độ phức tạp thời gian: $O(N)$, trong đó $N$ là số lượng token. Chúng ta duyệt qua mảng một lần.*
*   **Space Complexity:** $O(N)$ in the worst case. In an expression like `[1, 2, 3, 4, 5, +, +, +, +]`, the stack would store almost all operands before processing the operators. 
    *Độ phức tạp không gian: $O(N)$ trong trường hợp xấu nhất. Trong một biểu thức dài toàn toán hạng trước khi có toán tử, ngăn xếp sẽ lưu trữ hầu hết các số đó.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["4", "13", "5", "/", "+"]`

1.  `token = "4"`: Push 4. [Stack: 4]
2.  `token = "13"`: Push 13. [Stack: 4, 13]
3.  `token = "5"`: Push 5. [Stack: 4, 13, 5]
4.  `token = "/"`:
    - Pop `b = 5`, `a = 13`.
    - Compute `13 / 5 = 2`.
    - Push 2. [Stack: 4, 2]
5.  `token = "+"`:
    - Pop `b = 2`, `a = 4`.
    - Compute `4 + 2 = 6`.
    - Push 6. [Stack: 6]

**Result:** 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

RPN evaluation is a classic implementation of the Stack data structure. It is vital to remember that when popping operands for subtraction or division, the **second** popped element is the **left** operand, and the **first** popped is the **right** operand. Using a `switch` statement or a lookup table for operators can keep the code clean and extensible.
*Đánh giá RPN là một ứng dụng kinh điển của cấu trúc dữ liệu Ngăn xếp. Điều quan trọng cần nhớ là khi lấy các toán hạng cho phép trừ hoặc phép chia, phần tử được lấy ra **thứ hai** là toán hạng **bên trái**, và phần tử lấy ra **đầu tiên** là toán hạng **bên phải**. Sử dụng câu lệnh `switch` có thể giúp mã sạch sẽ và dễ mở rộng hơn.*
---
*Đôi khi những con số phải chờ đợi đủ lâu để gặp được người dẫn dắt chúng đi tới kết quả cuối cùng.*
Sometimes numbers must wait long enough to meet the one that leads them to the final result.
