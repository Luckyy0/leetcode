# 951. Flip Equivalent Binary Trees / Cây Nhị phân Tương đương bằng phép Lật

## Problem Description / Mô tả bài toán
For a binary tree, we can define a **flip** operation: choose any node, and swap its left and right child subtrees.
Đối với một cây nhị phân, chúng ta có thể định nghĩa một thao tác **lật**: chọn bất kỳ nút nào và hoán đổi các cây con bên trái và bên phải của nó.

Two binary trees are flip equivalent if they can be made equal after some number of flip operations. Return `true` if they are flip equivalent.
Hai cây nhị phân được gọi là tương đương bằng phép lật nếu chúng có thể trở nên bằng nhau sau một số thao tác lật. Trả về `true` nếu chúng tương đương bằng phép lật.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Tree Comparison / So sánh Cây Đệ quy
Algorithm:
1. If both are null, return `true`.
2. If only one is null or values differ, return `false`.
3. For children:
   - Case 1: No flipping needed. Check `(r1.left, r2.left)` and `(r1.right, r2.right)`.
   - Case 2: Flipping needed. Check `(r1.left, r2.right)` and `(r1.right, r2.left)`.
4. Return `Case 1 || Case 2`.

### Complexity / Độ phức tạp
- **Time**: O(min(N, M)).
- **Space**: O(min(H1, H2)) for recursion stack.

---

## Analysis / Phân tích

### Approach: Structural Invariance Check
Determine equivalence by testing both direct and mirrored configurations at every node level. The recursive nature ensures that if any branch can be matched through a local swap, the entire tree's structural symmetry (after potential flips) is verified.
Xác định tính tương đương bằng cách kiểm tra cả cấu hình trực tiếp và đối xứng ở mọi cấp độ nút. Bản chất đệ quy đảm bảo rằng nếu bất kỳ nhánh nào có thể khớp nhau thông qua phép hoán đổi cục bộ, tính đối xứng cấu trúc của toàn bộ cây (sau những lần lật tiềm năng) sẽ được xác minh.

---
