# Analysis for Construct Binary Tree from String
# *Phân tích cho bài toán Xây dựng Cây Nhị phân từ Chuỗi*

## 1. Problem Essence & Parser
## *1. Bản chất vấn đề & Trình phân tích cú pháp*

### The Challenge
### *Thách thức*
Parsing a serialized tree string `Val(Left)(Right)`.
- Finding matching parentheses is the key step.
- Handling negative numbers.

### Strategy: Recursive Parsing or Stack
### *Chiến lược: Phân tích cú pháp Đệ quy hoặc Stack*

1.  **Parse Root Value:** Read characters until `(` or end of string. This is the root value. Create node.
2.  **Find Left Substring:** If next char is `(`, find the matching `)`. This substring (inside parens) is input for left child recursion.
3.  **Find Right Substring:** If after left child there is another `(`, matching `)` encloses right child.

### Helper: Find Matching Parenthesis
### *Hàm phụ trợ: Tìm Dấu ngoặc Tương ứng*
- Scan from start index, count open `(`, close `)`. Balance 0 means end.

---

## 2. Approach: Recursion
## *2. Hướng tiếp cận: Đệ quy*

### Logic
### *Logic*
(See above). The index management can be tricky with recursion passing substrings. Better to pass global index or `start/end` pointers.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursive Definition:** Tree structure matches recursion perfectly.
    *Định nghĩa đệ quy: Cấu trúc cây hoàn toàn phù hợp với đệ quy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each char processed constant times?
    *Wait, `substring` takes O(N), so passing substrings makes it O(N^2).
    *Use global index to make it O(N).*
*   **Space Complexity:** $O(H)$ recursion stack.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `4(2)(6)`
1. Read `4`. Node(4).
2. Found `(`. Identify `(2)`. Recurse `2`.
   - Read `2`. Node(2). No children. Ret.
   - Attach left.
3. Found `(`. Identify `(6)`. Recurse `6`.
   - Read `6`. Node(6). Ret.
   - Attach right.
4. Return Node(4).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Recursive parsing with index tracking.
*Phân tích cú pháp đệ quy với theo dõi chỉ số.*
---
*Cấu trúc (structure) thường ẩn sau những lớp vỏ bọc phức tạp (parenthesis). Bằng cách bóc tách từng lớp (parsing), tìm ra điểm bắt đầu và kết thúc của mỗi bộ phận (matching), ta có thể tái tạo lại hình dáng nguyên bản của sự sống (binary tree).*
Structure often hides behind complex shells (Parenthesis). By peeling each layer (Parsing), finding the beginning and end of each part (Matching), we can recreate the original shape of life (Binary Tree).
