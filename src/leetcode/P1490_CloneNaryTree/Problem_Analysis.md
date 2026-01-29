# 1490. Clone N-ary Tree / Sao chép Cây N-ary

## Problem Description / Mô tả bài toán
Clone a N-ary tree (deep copy).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive DFS
Cloning function `clone(node)`.
Create new node with `val`.
Recursively clone children.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H) or O(N).

---

## Analysis / Phân tích

### Approach: Recursion
Map is not strictly needed if structure is tree (no cycles/shared nodes beside parent-child).
Just simple recursion.
Đệ quy đơn giản.

---
