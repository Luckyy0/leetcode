# Analysis for Ternary Expression Parser
# *Phân tích cho bài toán Trình phân tích Biểu thức Tam phân*

## 1. Problem Essence & Right-to-Left Evaluation
## *1. Bản chất vấn đề & Đánh giá Từ phải sang trái*

### The Challenge
### *Thách thức*
Evaluating nested ternary expressions. The key observation is that nested expressions are naturally solved by starting from the innermost (rightmost) `?` symbols.

### Strategy: Stack-based Evaluation
### *Chiến lược: Đánh giá dựa trên Ngăn xếp*

1.  **Iterate Backward:** Traverse the string from the **end** (index $N-1$) to the **start** (index 0).
2.  **Tracking:** Use a `Stack` to store characters.
3.  **Process:**
    - If the current character is not `?`:
        - Simply push it onto the stack.
    - If the current character is `?`:
        - We just encountered a condition. The next character encountered (while going backward) will be the condition itself (`T` or `F`).
        - The stack already contains `expression1` (top) followed by `:` (second top) followed by `expression2` (third top).
        - Pop `expression1`, pop `:`, and pop `expression2`.
        - Check the condition (`expression.charAt(i-1)`).
        - If `T`, push `expression1` back onto the stack.
        - If `F`, push `expression2` back onto the stack.
        - Move index `i` an extra step backward to skip the condition.

---

## 2. Approach: Right-to-Left Stack
## *2. Hướng tiếp cận: Ngăn xếp Từ phải sang trái*

### Logic
### *Logic*
(See above). By going backward, we ensure that the "innermost" or "rightmost" expressions are evaluated first and their results are placed on the stack to be used by "outer" expressions.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Complexity:** Single pass from right to left.
    *Độ phức tạp tuyến tính: Duyệt một lần từ phải sang trái.*
*   **Logical Simplicity:** Avoids complex recursion or parenthesis matching.
    *Sự đơn giản logic: Tránh việc đệ quy phức tạp hoặc khớp dấu ngoặc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the stack.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `F?1:T?4:5`
1. Stack (right to left): `5`, `:`, `4`, `?`, `T`, `:`, `1`, `?`, `F`? Wait, let's trace:
    - Push `5`.
    - Push `:`.
    - Push `4`. 
    - Encounter `?`. 
        - Condition is `T` (at index `i-1`).
        - Pop `4` (exp1), pop `:`, pop `5` (exp2).
        - Condition is `T` $\to$ Push `4`. **Stack: [4]**.
    - Skip `T`. `i` moves backward.
    - Push `:`. **Stack: [4, :]**.
    - Push `1`. **Stack: [4, :, 1]**.
    - Encounter `?`.
        - Condition is `F` (at index `i-1`).
        - Pop `1` (exp1), pop `:`, pop `4` (exp2).
        - Condition is `F` $\to$ Push `4`. **Stack: [4]**.
Result: "4".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Stack evaluation traversing from right to left.
*Đánh giá bằng ngăn xếp duyệt từ phải sang trái.*
---
*Đôi khi để giải quyết một vấn đề phức tạp và lồng ghép (nested), ta phải bắt đầu từ nơi kết thúc (right-to-left). Bằng cách giải quyết những lựa chọn nhỏ nhất ở sâu bên trong, ta tích lũy được lời giải cho bức tranh lớn. Ngăn xếp (stack) không chỉ lưu giữ dữ liệu, mà còn lưu giữ những quyết định đã qua để dẫn lối đến kết quả cuối cùng của sự thật (T/F).*
Sometimes to solve a complex and nested problem (nested), we have to start from where we end (right-to-left). By solving the smallest choices deep inside, we accumulate solutions for the big picture. The stack (stack) not only stores data, but also stores past decisions to lead to the final result of the truth (T/F).
