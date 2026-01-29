# 331. Verify Preorder Serialization of a Binary Tree / Xác Minh Tuần Tự Hóa Preorder Của Cây Nhị Phân

## Problem Description / Mô tả bài toán
One way to serialize a binary tree is to use **preorder traversal**. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as `'#'`.
Một cách để tuần tự hóa cây nhị phân là sử dụng **duyệt preorder**. Khi gặp nút không null, ghi giá trị. Nếu null, ghi `'#'`.

Given a string of comma-separated values `preorder`, return `true` if it is a correct preorder traversal serialization of a binary tree.
Cho chuỗi `preorder`, trả về `true` nếu nó là một chuỗi tuần tự hóa hợp lệ.

It is **guaranteed** that each comma-separated value in the string must be either an integer or a character `'#'` representing null pointer.
You may assume that the input format is always valid, for example it could never contain two consecutive commas such as `"1,,3"`.

### Example 1:
```text
Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
```

### Example 2:
```text
Input: preorder = "1,#"
Output: false
```

### Example 3:
```text
Input: preorder = "9,#,#,1"
Output: false
```

## Constraints / Ràng buộc
- `1 <= preorder.length <= 10^4`
- `preorder` consist of integers in the range `[0, 100]` and characters `'#'` separated by commas.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Slot Counting (Degree Counting) / Đếm Slot
In a binary tree:
- Start with `slots = 1` (for root).
- Visiting a node:
    - Consume 1 slot (it occupies the position provided by parent).
    - If `slots <= 0` before checking type, return `false`.
    - If node is Non-Null: Creates 2 new slots (children).
    - If node is Null (`#`): Creates 0 new slots.
- At the end, `slots` must be `0`.

Alternative: Out-degree vs In-degree.
Every node provides 1 in-degree (except root).
Non-null node provides 2 out-degrees.
Null node provides 0 out-degrees.
Total In = Total Out.

**Algorithm**:
1.  `slots = 1`.
2.  Split string by `,`.
3.  For each node:
    - `slots--`.
    - If `slots < 0` return `false`.
    - If `node != "#"`: `slots += 2`.
4.  Return `slots == 0`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) if iterating string carefully, or O(N) if split.

---

## Analysis / Phân tích

### Approach: Slot Counting

**Edge Cases**:
1.  Empty string? Constraint says len >= 1.
2.  "#": slots=1 -> slots=0. Valid.
3.  "#, #": slots=1 -> 0 (#) -> -1 (#). Invalid.

---
