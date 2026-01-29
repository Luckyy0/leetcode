# 536. Construct Binary Tree from String / Xây Dựng Cây Nhị Phân từ Chuỗi

## Problem Description / Mô tả bài toán
You need to construct a binary tree from a string consisting of parenthesis and integers.
Bạn cần xây dựng một cây nhị phân từ một chuỗi bao gồm dấu ngoặc đơn và các số nguyên.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
Toàn bộ đầu vào đại diện cho một cây nhị phân. Nó chứa một số nguyên theo sau là không, một hoặc hai cặp dấu ngoặc đơn. Số nguyên đại diện cho giá trị của nút gốc và một cặp dấu ngoặc đơn chứa một cây nhị phân con có cấu trúc tương tự.

You always start to construct the **left** child node from the first pair of parenthesis.
Bạn luôn bắt đầu xây dựng nút con **bên trái** từ cặp dấu ngoặc đơn đầu tiên.

### Example 1:
```text
Input: s = "4(2(3)(1))(6(5))"
Output: [4,2,6,3,1,5]
```

## Constraints / Ràng buộc
- `0 <= s.length <= 3 * 10^4`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Parsing / Phân tích cú pháp đệ quy
The structure is defined recursively: `Value` + `(LeftSubtree)` + `(RightSubtree)`.

Algorithm:
1. Parse the integer value at the beginning -> Create Root.
2. If the next char is '(', find the matching closing ')'.
   - The substring inside is for the Left Child. Recurse.
3. If there is another '(' after the left child, find its matching closing ')'.
   - The substring inside is for the Right Child. Recurse.
4. Return Root.

Finding the matching parenthesis can be done by counting balance (open +1, closed -1).

### Complexity / Độ phức tạp
- **Time**: O(N^2) if using simplistic string substring, O(N) if passing index reference.
- **Space**: O(H) for recursion.

---

## Analysis / Phân tích

### Approach: Recursive Descent Parser

**Algorithm**:
1.  Parse root value.
2.  Detect parentheses for children.
3.  Recursively construct left/right subtrees.
4.  Manage string index.

---
