# 652. Find Duplicate Subtrees / Tìm Cây Con Trùng Lặp

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return all duplicate subtrees.
Cho `root` của một cây nhị phân, hãy trả về tất cả các cây con trùng lặp.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Đối với mỗi loại cây con trùng lặp, bạn chỉ cần trả về nút gốc của bất kỳ một trong số chúng.

Two trees are duplicate if they have the same structure with the same node values.
Hai cây là trùng lặp nếu chúng có cùng cấu trúc với cùng giá trị nút.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Serialization + HashMap / Tuần Tự Hóa + HashMap
Serialize each subtree to a string representation.
Use HashMap to count occurrences of each serialization.
If count becomes 2, add the root to result.

Serialization format: `val,left,right` or use special markers for null.

### Complexity / Độ phức tạp
- **Time**: O(N^2) worst case (serialization).
- **Space**: O(N^2).

---
