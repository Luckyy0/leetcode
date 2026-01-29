# 606. Construct String from Binary Tree / Xây Dựng Chuỗi Từ Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
Cho `root` của một cây nhị phân, xây dựng một chuỗi bao gồm dấu ngoặc đơn và số nguyên từ một cây nhị phân theo cách duyệt tiền thứ tự, và trả về nó.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
Bỏ qua tất cả các cặp dấu ngoặc đơn rỗng không ảnh hưởng đến mối quan hệ ánh xạ 1-1 giữa chuỗi và cây nhị phân ban đầu.

### Example 1:
```text
Input: root = [1,2,3,4]
Output: "1(2(4))(3)"
Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Preorder Traversal (DFS) / Duyệt Tiền Thứ Tự (DFS)
Recursive logic:
Format: `root.val(left)(right)`
Rules:
- If left is null and right is null -> `root.val` (no parens).
- If left is null but right exists -> `root.val()(right)`. (Need empty parens to preserve structure)
- If left exists but right is null -> `root.val(left)`. (Can omit right parens)

Algorithm:
1. Append `root.val`.
2. If `left` present: `(` + recurse(left) + `)`.
3. If `left` missing but `right` present: `()` + `(` + recurse(right) + `)`.
4. If `right` present (and left present): `(` + recurse(right) + `)`.
   - Wait, logic refinement:
   - Always append `(left)` if left exists.
   - If left missing AND right exists, append `()`.
   - Append `(right)` if right exists.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive Construction

**Algorithm**:
1.  Base case: return empty if null.
2.  String builder append value.
3.  Check children for explicit rules regarding empty parenthesis.
4.  Recursively build substrings.

---
