# Analysis for Mini Parser
# *Phân tích cho bài toán Bộ phân tích Nhỏ*

## 1. Problem Essence & Stack-based Deserialization
## *1. Bản chất vấn đề & Giải tuần tự hóa dựa trên Ngăn xếp*

### The Challenge
### *Thách thức*
Parsing a nested structure represented by a string. Elements can be integers or other nested lists.

### Strategy: Stack Tracking
### *Chiến lược: Đeo bám bằng Ngăn xếp*
1.  **Direct Integer Case:** If the string doesn't start with `[`, it's just a raw number. return it immediately.
2.  **Nested Case:**
    - Use a `Stack<NestedInteger>` to maintain the hierarchy.
    -   `[`: Create a new `NestedInteger` list and push it onto the stack.
    -   Digits/`-`: Parse the entire number. Add it to the current `NestedInteger` at the top of the stack.
    -   `,`: Separator, skip.
    -   `]`: Current list is finished. Pop it. If the stack is not empty, add the popped list to the new top element (its parent). If the stack is empty, this was the final result.

---

## 2. Approach: Iterative Parsing
## *2. Hướng tiếp cận: Phân tích Lặp*

### Logic
### *Logic*
(See above). We maintain a pointer or use a loop to extract numbers whenever a digit or minus sign is encountered.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single pass through the string.
    *Hiệu quả O(N): Duyệt chuỗi một lần.*
*   **Recursive-free:** Avoids stack overflow for deeply nested structures by using an explicit stack.
    *Không đệ quy: Tránh lỗi tràn ngăn xếp cho các cấu trúc lồng sâu bằng cách dùng ngăn xếp tường minh.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(D)$, where $D$ is the maximum depth of the nested list.
    *Độ phức tạp không gian: $O(D)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `"[123,[456]]"`
1. `[`: Stack = `[ List1 ]`.
2. `123`: List1.add(123). Stack = `[ List1 ]`.
3. `,`: skip.
4. `[`: Stack = `[ List1, List2 ]`.
5. `456`: List2.add(456). Stack = `[ List1, List2 ]`.
6. `]`: Pop List2. Add to List1. Stack = `[ List1 ]`.
7. `]`: Pop List1. Result = List1.
**Result:** `[123, [456]]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Stack-based iterative parsing.
*Phân tích lặp bằng ngăn xếp.*
---
*Mọi sự phức tạp lồng ghép (nested structures) đều có thể được tháo gỡ nếu chúng ta biết cách ghi nhớ từng tầng của vấn đề (stack). Bằng cách tập trung vào hiện tại (stack top) và chỉ trở về tầng trên khi nhiệm vụ hiện tại đã hoàn tất (pop), ta sẽ không bao giờ bị lạc trong mê cung của dữ liệu.*
Every nested complexity can be unraveled if we know how to remember each layer of the problem (stack). By focusing on the present (stack top) and only returning to the upper layer when the current task is completed (pop), we will never be lost in the maze of data.
