# Analysis for Basic Calculator III
# *Phân tích cho bài toán Máy tính Cơ bản III*

## 1. Problem Essence & Recursive Evaluation
## *1. Bản chất vấn đề & Đánh giá Đệ quy*

### The Challenge
### *Thách thức*
Evaluate expressions with standard precedence (`* /` > `+ -`) and parentheses.
*Đánh giá các biểu thức với độ ưu tiên chuẩn (`* /` > `+ -`) và dấu ngoặc.*

This combines Basic Calculator I (parentheses, + -) and II (* /).
*Bài toán này kết hợp Máy tính Cơ bản I (ngoặc, + -) và II (* /).*

---

## 2. Strategy: Recursion or Two Stacks
## *2. Chiến lược: Đệ quy hoặc Hai Ngăn xếp*

### Algorithm
### *Thuật toán*

1.  **Recursion via Loop:**
    - We iterate through the string.
    - Maintain a `currentVal` (number being parsed), `lastOp` (operator before current number), and a stack/list of values to sum up at the end.
    *   **Đệ quy qua Vòng lặp:** Duyệt qua chuỗi. Duy trì `currentVal`, `lastOp`, và một danh sách các giá trị để tổng hợp cuối cùng.*

2.  **Handling Operators:**
    - If `char` is digit: build number.
    - If `char` is `(`: Find matching `)` parenthesis. Recursively call `calculate` on the substring inside. Treat the result as the `currentVal`.
    - If `char` is operator `+ - * /` or end of string: Apply `lastOp` to `currentVal` and push to stack.
        - `+`: push `val`.
        - `-`: push `-val`.
        - `*`: pop, multiply, push.
        - `/`: pop, divide, push.
        - Update `lastOp` = current char. Reset `currentVal = 0`.
    *   **Xử lý Toán tử:** Nếu là số: xây dựng số. Nếu là `(`: Gọi đệ quy cho phần bên trong. Kết quả coi như `currentVal`. Nếu là toán tử: Áp dụng `lastOp` vào `currentVal` và đẩy vào ngăn xếp (hoặc thực hiện phép nhân/chia ngay).*

3.  **Result:** Sum all values in stack.
    *   **Kết quả:** Tổng tất cả giá trị trong ngăn xếp.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
int i = 0;
public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    char op = '+';
    int num = 0;
    while (i < s.length()) {
        char c = s.charAt(i++);
        if (Character.isDigit(c)) num = num * 10 + (c - '0');
        if (c == '(') num = calculate(s); // Recurse
        
        if (i >= s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
            if (op == '+') stack.push(num);
            else if (op == '-') stack.push(-num);
            else if (op == '*') stack.push(stack.pop() * num);
            else if (op == '/') stack.push(stack.pop() / num);
            
            op = c;
            num = 0;
            if (c == ')') break; // Return from recursion
        }
    }
    int res = 0;
    for (int val : stack) res += val;
    return res;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each char visited constant times.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for recursion/stack.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Exp:** `2*(5+5)`
1. `i=0`, char `2`. Num=2. Next `*`. Push 2. Op=`*`.
2. `i=2`, `(`. Recurse.
   - Sub-calc: `5+5`.
   - `5`: push 5. Op=`+`.
   - `+`: op=`+`.
   - `5`: push 5.
   - End/`)`: Sum stack `5+5=10`. Ret 10.
3. Back in main. Num=10. Op was `*`. Stack has `2`.
4. Apply `*`: pop 2, `2*10=20`. Push 20.
5. End. Sum=20.
**Result:** 20.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Using a global index `i` simpler than passing substrings.
*Sử dụng chỉ số toàn cục `i` đơn giản hơn việc truyền chuỗi con.*
