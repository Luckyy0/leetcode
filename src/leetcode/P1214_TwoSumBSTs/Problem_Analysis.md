# 1214. Two Sum BSTs / Tổng Hai BST

## Problem Description / Mô tả bài toán
Given two binary search trees `root1` and `root2` and an integer `target`.
Return `true` if there is a value `x` in `root1` and value `y` in `root2` such that `x + y == target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BST Search / Set Conversion
Approach 1: Convert `root1` to HashSet. Traverse `root2` and check `target - val` in set.
Approach 2: Two Iterators. One works on `root1` increasing, another on `root2` decreasing?
Sorted arrays analogy.
Inorder traversal gives sorted list.
We want `a + b = target`. `a` from list1, `b` from list2.
If `list1` sorted ASC, `list2` sorted DESC (reverse inorder), we scan like Two Pointers.
Or `list1` ASC, `list2` ASC -> classic 2 pointers.

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(N + M) or O(H1 + H2) with iterators.

---

## Analysis / Phân tích

### Approach: Recursive Search / Complement Lookup
Traverse the first BST (e.g., `root1`). For each node with value `x`, search for `target - x` in the second BST (`root2`). Since `root2` is a BST, searching takes logarithmic time on average. Alternatively, traverse `root1` entirely to store its elements in a HashSet, then traverse `root2` checking for complements in the set (O(N+M) time). Given typical tree sizes, the set approach is robust and simple.
Duyệt qua BST đầu tiên (ví dụ: `root1`). Đối với mỗi nút có giá trị `x`, hãy tìm kiếm `target - x` trong BST thứ hai (`root2`). Vì `root2` là một BST, việc tìm kiếm mất thời gian logarit trung bình. Ngoài ra, duyệt toàn bộ `root1` để lưu các phần tử của nó vào HashSet, sau đó duyệt `root2` kiểm tra các phần tử bù trong tập hợp (thời gian O(N+M)). Với kích thước cây điển hình, phương pháp tập hợp rất mạnh mẽ và đơn giản.

---
