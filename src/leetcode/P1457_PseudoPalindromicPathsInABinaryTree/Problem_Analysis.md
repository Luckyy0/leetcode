# 1457. Pseudo-Palindromic Paths in a Binary Tree / Các ĐƯờng dẫn Giả Palindrome trong Cây Nhị phân

## Problem Description / Mô tả bài toán
Binary Tree values 1-9.
Count paths from root to leaf where values form a pseudo-palindrome (at most one value with odd frequency).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with Bitmask
Values 1-9. Bitmask length 10. `mask |= (1 << val)`.
XOR toggle each value on path: `mask ^= (1 << val)`.
Leaf check:
Pseudo-palindrome if `mask` has at most 1 bit set (i.e., `mask & (mask - 1) == 0`).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive DFS
DFS traversal. Pass bitmask of counts (parity).
At node `u`, update `mask ^= (1 << u.val)`.
If leaf: check `mask`. If power of 2 or 0, increment count.
Recurse left, right.
Duyệt DFS. Truyền bitmask của số đếm (chẵn lẻ).
Tại nút `u`, cập nhật `mask ^= (1 << u.val)`.
Nếu là lá: kiểm tra `mask`. Nếu lũy thừa của 2 hoặc 0, tăng số đếm.

---
